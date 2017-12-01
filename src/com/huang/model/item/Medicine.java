package com.huang.model.item;

/**
 * 药品类
 * @author huangyao
 * @date 2017年11月30日
 */
@SuppressWarnings("serial")
public class Medicine extends Items{
	
	private String effect;//作用
	private int quantity;//数值
	
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Medicine(String name, int amount, int type, String effect,
			int quantity) {
		super(name, amount, type);
		this.effect = effect;
		this.quantity = quantity;
	}
	
}

