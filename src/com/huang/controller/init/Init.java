package com.huang.controller.init;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import com.huang.controller.config.Config;
import com.huang.model.item.Medicine;
import com.huang.model.item.Weapon;
import com.huang.model.person.Boss;
import com.huang.model.person.Hero;

public class Init {
	

	
	static int weaponAttack = 0;
	static String weaponName = null;
	static boolean weaponState = false;
	// 初始化英雄的各项数值
	public static void heroInit(Hero h) throws ClassNotFoundException {
		
			h.setName("亚瑟");
			h.setBlood(1500);
			h.setMagic(500);
			h.setPhysicalDefend(50);// 物防
			h.setMagicDefend(50);// 法防

			/*
			 * 初始化武器的各项数值 现在要装备“白银之剑” 循环获取武器列表里的武器，找到要装备的武器，设置它的状态为true(已装备)
			 */
			for (Weapon a : h.getWeaponColl()) {
				if (a.getName().equals("白银之剑")) {
					a.setState(true);
					weaponAttack = a.getAttack();
					weaponName = a.getName();
					weaponState = a.isState();
				}
				break;
			}
			if (weaponName == null || weaponName.equals("")) {
				weaponName = "未装备";
			}
			System.out.println("英雄：" + h.getName() + " , 血量：" + h.getBlood()
					+ " , 魔法：" + h.getMagic() + " , 物防：" + h.getPhysicalDefend()
					+ " , 法防：" + h.getMagicDefend() + " , 武器：" + weaponName+" , 等级："+h.getLevel()+" , 经验值："+h.getExp());
			
			//保存本地
//			Save.writeHero(h);
		
	}
	
	public static void initHeroLevelExp(Hero h){
		h.setLevel(1);//等级
		h.setExp(0);//经验值
	}
	
	public static void bossInit(Boss b) {
		b.setName("恶魔领主");
		b.setBlood(3000);
		b.setMagic(300);
		b.setPhysicalDefend(100);// 物防
		b.setMagicDefend(100);// 法防
	
	}

	// 物品初始化
	public static void itemsInit(Hero h) {
			
		// 获取武器列表
		Set<Weapon> weaponColl=new HashSet<>();
		/*
		 * new Weapon(名称，数量，类型，状态，攻击力)
		 */
		// 列表为空就添加武器
		if (weaponColl.size() == 0) {
			weaponColl.add(new Weapon("白银之剑", 1, 3, false, 30));
			weaponColl.add(new Weapon("奥金斧", 3, 3, false, 45));
		}
		// 获取药品列表
		Set<Medicine> medicineColl=new HashSet<>();
		/*
		 * new medicine(名称，数量，类型，效果，效果数值)
		 */
		// 列表为空就添加药品
		if (medicineColl.size() == 0) {
			medicineColl.add(new Medicine("大黄丹", 3, 0, "使用后回复生命值500", 500));
			medicineColl
					.add(new Medicine("百草果", 99, 1, "使用后回复魔法值300", 300));
			medicineColl.add(new Medicine("一飞升天", 10, 2, "使用后获得3000经验",
					3000));
		}
		//英雄获取所有武器和药品
		h.setWeaponColl(weaponColl);
		h.setMedicineColl(medicineColl);
	
	}
	public static void initConfig(){
		// 设置升级规则K=英雄等级 ; V=需要升级的经验
		LinkedHashMap<Integer, Integer> levelMap =new LinkedHashMap<>();
		if (levelMap.size() == 0) {
			levelMap.put(1, 500);
			levelMap.put(2, 1500);
			levelMap.put(3, 3000);
			levelMap.put(4, 5000);
			levelMap.put(5, 7500);
			levelMap.put(6, 10000);
			levelMap.put(7, 13000);
		}
		Config.setLevelMap(levelMap);
		
	}

		
	
	public static void start(Hero h,Boss b) throws InterruptedException{
		System.out.println();
		int heroBlood = h.getBlood();// 英雄血量
		int heroMagic = h.getMagic();// 英雄魔法
		int bossBlood = b.getBlood();// BOSS血量
		int bossMagic = b.getMagic();// BOSS魔法
		int heroTrueNormalAttack = h.normalAttack() + weaponAttack
				- b.getPhysicalDefend();// 英雄普攻真实伤害(普攻+武器攻击-物防)
		int heroTrueMagicAttack = h.magicAttack() - b.getMagicDefend();// 英雄魔法真实伤害
		int bossTrueNormalAttack = b.normalAttack() - h.getPhysicalDefend();// BOSS普攻真实伤害(普攻-物防)
		int bossTrueMagicAttack = b.magicAttack() - h.getMagicDefend();// BOSS魔法真实伤害

		while (heroBlood > 0 && bossBlood > 0) {
			System.out.println("英雄开始攻击");
			System.out.println("----------------------");
			System.out.println();
			bossBlood -= b.bloodCost(heroTrueNormalAttack);// 普通攻击BOSS后BOSS的剩余生命值
			System.out.println(h.getName() + "普攻真实伤害：" + heroTrueNormalAttack
					+ " ," + b.getName() + "剩余生命值：" + bossBlood);
			System.out.println();
			System.out.println("BOSS开始攻击");
			System.out.println("----------------------");
			heroBlood -= h.bloodCost(bossTrueNormalAttack);// 被BOSS攻击后剩余生命值
			System.out.println(b.getName() + "普攻真实伤害：" + bossTrueNormalAttack
					+ " ," + h.getName() + "剩余生命值：" + heroBlood);
			System.out.println();

			Thread.sleep(1000);// 延迟1秒
			System.out.println();
			if (heroMagic > 0 && heroBlood > 0) {
				System.out.println("英雄开始攻击");
				System.out.println("----------------------");
				bossBlood -= b.bloodCost(heroTrueMagicAttack);// 魔法攻击BOSS后BOSS的剩余生命值
				heroMagic -= h.magicCost();// 剩余魔法值
				System.out.println(h.getName() + "魔法真实伤害："
						+ heroTrueMagicAttack + " ," + b.getName() + "剩余生命值："
						+ bossBlood);
				System.out.println();
				Thread.sleep(1000);
			}
			if (bossMagic > 0 && bossBlood > 0) {
				System.out.println("BOSS开始攻击");
				System.out.println("----------------------");
				heroBlood -= h.bloodCost(bossTrueMagicAttack);// 魔法攻击英雄后英雄的剩余生命值
				bossMagic -= b.magicCost();// 剩余魔法值
				System.out.println(b.getName() + "魔法真实伤害："
						+ bossTrueMagicAttack + " ," + h.getName() + "剩余生命值："
						+ heroBlood);
				System.out.println();
				Thread.sleep(1000);
			}

		}
		if (heroBlood <= 0) {
			System.out.println("啊，打不过" + b.getName() + "，我再练练级！");
		}
		if (bossBlood <= 0) {
			//获取BOSS死亡时掉落的经验值
			int bossExp=b.getExp();
			//获取英雄当前等级
			int heroLevel=h.getLevel();
			//获取当前经验值
			int heroExp=h.getExp();
			//获取目前升级所需的经验值
			int currentNeedExp=Config.getLevelMap().get(heroLevel);
			
			//当获取到的经验值大于所需经验值1,500 ;2,1500;3,3000
			while(bossExp>=currentNeedExp){
				/*
				 * 第一次循环：heroLevel:1 heroExp:0 bossExp=1000
				 * 700=1200-(500-0)
				 */
				int overflowExp=bossExp-(currentNeedExp-heroExp);
				/*
				 * 英雄升级 heroLevel:2 heroExp:700 bossExp=700
				 * 
				 */
				h.setLevel(heroLevel++);
				currentNeedExp=Config.getLevelMap().get(heroLevel);
				//如果溢出的经验值大于当前升级所需经验值
				bossExp=overflowExp;
				//设置英雄的经验值
				h.setExp(bossExp);
				//设置英雄的等级
				h.setLevel(heroLevel);
			}
			System.out.println("哈哈，我终于战胜了" + b.getName() + ",圣光会赐予我胜利！当前等级："+heroLevel+",当前经验值："+h.getExp());
		}
		
	}

}
