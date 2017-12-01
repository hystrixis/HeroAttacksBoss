package com.huang.model.item;

import java.io.Serializable;

/**
 * 物品类，背包里物品的通用属性
 * @author huangyao
 * @date 2017年11月29日
 */
@SuppressWarnings("serial")
public class Items implements Serializable {
  
	private String name;//名称
	private int amount;//数量
	private int type;//类型，0：红药，1：蓝药，2：经验药，3：武器，4：防具 5:攻击buff x30%
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Items(String name, int amount, int type) {
		super();
		this.name = name;
		this.amount = amount;
		this.type = type;
	}
	
}
