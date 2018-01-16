package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;

	@Test
	public void testupdateShopDao() {
		Shop shop = new Shop();
		//PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		//owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setShopId(1L);
		//shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("插花羊肉馆2");
		shop.setShopDesc("test");
		shop.setPhone("15850651319");
		shop.setShopAddr("chahua");	
		shop.setShopImg("test");
		shop.setPriority(1);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("hao");
		int jun = shopDao.updateShop(shop);
		assertEquals(1, jun);
	}
}
