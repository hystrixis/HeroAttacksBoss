package com.huang.model.item;
/**
 * 
 * @author huangyao
 * @date 2017年11月30日
 */
@SuppressWarnings("serial")
public class Weapon extends Equipment {
	
	private int attack;//攻击力
	

	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public Weapon(String name, int amount, int type, boolean state, int attack) {
		super(name, amount, type, state);
		this.attack = attack;
	}

}
