package com.huang.model.item;

//定义一个装备类，包括武器和防具
@SuppressWarnings("serial")
public class Equipment extends Items{
	
	
	private boolean state;//状态，true装备中，false未装备
	

	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Equipment(String name, int amount, int type, boolean state) {
		super(name, amount, type);
		this.state = state;
	}
	
	
	
	
	
}
