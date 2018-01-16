package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.mchange.util.AssertException;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopservice;
	
	@Test
	public void testAddShop(){
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setShopId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("插花羊肉馆5");
		shop.setShopDesc("test");
		shop.setPhone("15850651319");
		shop.setShopAddr("chahua");	
		//shop.setShopImg("test");
		shop.setPriority(1);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("hao");
		File shopImg=new File("H:/1.jpg");
		ShopExecution se=shopservice.addShop(shop,shopImg);
		assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
	}
}
