package com.huang.controller;

import java.io.File;

import com.huang.controller.init.Init;
import com.huang.controller.save.Save;
import com.huang.model.person.Boss;
import com.huang.model.person.Hero;

/**
 * 
 * @author huangyao
 */

public class StartBattle {

	public static void start() throws ClassNotFoundException, InterruptedException {
		// 进行初始化		
		File file=new File("flag.dat");
		if(file.exists()){
			init();
		}else{
			init();
			Save.writeFlag(false);
		}
	}
	
	static void init() throws ClassNotFoundException, InterruptedException{
		
		Hero h=new Hero();
		Boss b=new Boss();
		//文件存在，返回false
		boolean flag=Save.readFlag();
		Init.initConfig();
		//flag为true，表示尚未初始化
		if(flag){
			//进行初始化
			Save.writeFlag(false);
			Init.itemsInit(h);
			Init.initHeroLevelExp(h);
			Init.heroInit(h);
			Init.bossInit(b);
			
		}else{
			//每次运行都初始化BOSS
			Init.bossInit(b);
			h=Save.readHero();
			Save.readItems(h);
			
		}

		Init.start(h, b);
		h.toString();
		Save.writeItems(h);
		Save.writeHero(h);
	}

}
