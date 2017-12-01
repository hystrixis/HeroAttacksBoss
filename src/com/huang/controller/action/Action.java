package com.huang.controller.action;

/**
 * 行为类
 * @author huangyao
 *
 */


public interface Action {
	
	/**
	 * title: Attack
	 * @author huangyao
	 */
	interface Attack {
        //Java接口中默认的是public abstract
		public abstract int normalAttack();//普攻
		public abstract int magicAttack();//法攻
		public abstract int bloodCost(int trueAttack);//扣的血量
		public abstract int magicCost();//魔法攻击时耗费的魔法值
		
	}
	
	/**
	 * title: Goods
	 * @author huangyao
	 */
	interface Goods{
		//使用红药
		void useBloodMedicines();
		//使用蓝药
		void useMagicMedicines();
		//使用武器
		void useWeapon();
		//使用技能
		void useSkills();
		
	}
	
	
	

}
