package com.huang.model.person;

import java.util.HashSet;
import java.util.Set;

import com.huang.controller.action.Action;
import com.huang.model.item.Medicine;
import com.huang.model.item.Weapon;


/**
 * 
 * @author huangyao
 * 英雄类，实现各项数值
 */

@SuppressWarnings("serial")
public class Hero extends Person implements 
								Action.Attack,Action.Goods{
	
	//人物等级,经验
	private int level=0;
	private int exp;
	
	//创建一个无重复的武器集合来保存各种武器
	private Set<Weapon> weaponColl;
	//创建一个无重复的药品来保存各种药品
	private Set<Medicine> medicineColl=new HashSet<>();

	public Set<Weapon> getWeaponColl() {
		return weaponColl;
	}

	public void setWeaponColl(Set<Weapon> weaponColl) {
		this.weaponColl = weaponColl;
	}

	public Set<Medicine> getMedicineColl() {
		return medicineColl;
	}

	public void setMedicineColl(Set<Medicine> medicineColl) {
		this.medicineColl = medicineColl;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
	
	

	@Override
	public String toString() {
		return ("英雄：" + getName() + " , 等级："+getLevel()+" , 经验值："+getExp());
	}

	public Hero() {
		super();
	}

	//普攻
	@Override
	public int normalAttack() {
		return 1500;
		
	}
	//法攻
	@Override
	public int magicAttack() {
		return 300;
		
	}
	//受到真实伤害减少的血量
	@Override
	public int bloodCost(int trueAttack) {
		return trueAttack;
	}
	//魔耗
	@Override
	public int magicCost() {
		return 30;
	}

	@Override
	public void useBloodMedicines() {
		
		
	}

	@Override
	public void useMagicMedicines() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useWeapon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useSkills() {
		// TODO Auto-generated method stub
		
	}
	
}
