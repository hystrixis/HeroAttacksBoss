package com.huang.model.person;


import com.huang.controller.action.Action;

/**
 * 
 * @author huangyao
 * BOSS类，实现各项数值
 */
@SuppressWarnings("serial")
public class Boss extends Person implements Action.Attack{
	
	//该BOSS掉落的经验值，默认3000
	private int exp=3000;
	

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public int normalAttack() {
		return 150;
	}

	@Override
	public int magicAttack() {
		return 300;
	}

	@Override
	public int bloodCost(int trueAttack) {
		return trueAttack;
	}

	@Override
	public int magicCost() {
		return 30;
	}
	
}
