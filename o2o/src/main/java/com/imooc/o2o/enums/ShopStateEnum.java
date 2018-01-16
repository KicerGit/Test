package com.imooc.o2o.enums;

public enum ShopStateEnum {
	CHECK(0, "审核中"), OFFLINE(-1, "非法店铺"), SUCCESS(1, "操作成功"),SHOP_NULL(1003,"店铺为空");

	private int state;

	private String stateInfo;

	private ShopStateEnum(int state, String stateInfo) {

		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static ShopStateEnum stateOf(int state) {
		for (ShopStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {

				return stateEnum;
			}

		}
		return null;

	}

	/*
	 * public static ShopStateEnum stateOf(int state) { ShopStateEnum stateEnum;
	 * 
	 * for (int i = 0; i < values().length; i++) {
	 * 
	 * } return null; }
	 */

}
