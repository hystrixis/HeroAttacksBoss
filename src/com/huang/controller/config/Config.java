package com.huang.controller.config;

import java.util.LinkedHashMap;


public class Config {
	//创建一个有序的哈希表来存储人物的等级与经验值
	public static LinkedHashMap<Integer, Integer> levelMap=new LinkedHashMap<>();

	public static LinkedHashMap<Integer, Integer> getLevelMap() {
		return levelMap;
	}

	public static void setLevelMap(LinkedHashMap<Integer, Integer> levelMap) {
		Config.levelMap = levelMap;
	}
	
	
	
	
	
}
