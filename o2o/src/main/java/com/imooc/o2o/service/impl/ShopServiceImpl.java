package com.imooc.o2o.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.ImageUtil;
import com.imooc.o2o.util.PathUtil;
@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopdao;

	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, File shopImg) {
		// TODO Auto-generated method stub
      //控制判断
		if (shop == null) {

			return new ShopExecution(ShopStateEnum.SHOP_NULL);
		}
		try {
			//给店铺信息赋值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//添加店铺信息
			int effectnum=shopdao.insertShop(shop);
			if(effectnum<=0){
				throw new ShopOperationException("店铺创建失败");
				
			}else{
				if(shopImg!=null){
					
					try {
						addShopImg(shop,shopImg);
					} catch (Exception e) {
						throw new ShopOperationException("店铺创建失败"+e.getMessage());
					}
					 effectnum=shopdao.updateShop(shop);
					 if(effectnum<=0){
						 throw new ShopOperationException("更新图片地址失败");
					 }
					
					
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addshop err "+e.getMessage());
			
		}
		return new ShopExecution(ShopStateEnum.CHECK,shop);
	}

	private void addShopImg(Shop shop, File shopImg) {
		// 获取图片的相对值的路径
		String dest=PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr=ImageUtil.generateThumbnail(shopImg, dest);
		//String shopImgAddr="H:/1.jpg";
		shop.setShopImg(shopImgAddr);
	}

}
