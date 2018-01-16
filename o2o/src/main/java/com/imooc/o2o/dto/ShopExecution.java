package com.imooc.o2o.dto;

import java.util.List;

import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;

public class ShopExecution {
private int state;

private String stateInfo;

private int count;


private Shop shop;

private List<Shop> shopList;

public ShopExecution(){
	
}
public int getState() {
	return state;
}

//店铺操作失败的构造器
public ShopExecution(ShopStateEnum stateEnum){
	this.state=stateEnum.getState();
	this.stateInfo=stateEnum.getStateInfo();
	
}
//店铺操作成功的时候
public ShopExecution(ShopStateEnum stateEnum,Shop shop){
	this.state=stateEnum.getState();
	this.stateInfo=stateEnum.getStateInfo();
	this.shop=shop;
	
}
public ShopExecution(ShopStateEnum stateEnum,List<Shop> shopList){
	this.state=stateEnum.getState();
	this.stateInfo=stateEnum.getStateInfo();
	this.shopList=shopList;
	
}


}
