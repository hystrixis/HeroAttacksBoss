package com.huang.controller.save;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.huang.model.person.Boss;
import com.huang.model.person.Hero;

public class Save {
	
	//定义全局变量Flag
	public static void writeFlag(boolean flag){
		File file=new File("flag.dat");
		try{
			//如果文件不存在就创建
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw=new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(String.valueOf(flag));
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static boolean readFlag(){
		boolean flag;
		String s;
		File file=new File("flag.dat");
		try{
			//如果文件存在就进行读取
			if(file.exists()){
				FileReader fr=new FileReader(file);
				@SuppressWarnings("resource")
				BufferedReader br=new BufferedReader(fr);
				s=br.readLine();
				if(s!=null){
					s+=br.readLine();
				}
				flag=Boolean.parseBoolean(s);
				return flag;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return true;
	}
	


	//将英雄数据保存在本地
	public static void writeHero(Hero h){
		File file=new File("hero.dat");
		try{
			FileOutputStream fos=new FileOutputStream(file);
			//序列化对象
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(h);
			oos.flush();//清空缓冲区数据
			oos.close();
			System.out.println("英雄数据保存成功");
			
		}catch(IOException e){
			System.out.println("英雄数据保存失败");
			e.printStackTrace();
		}
	}
	//读取保存在本地的英雄数据
	public static Hero readHero() throws ClassNotFoundException{
		File file=new File("hero.dat");
		Hero h=new Hero();
		try{
			FileInputStream fis=new FileInputStream(file);
			//对象反序列化
			ObjectInputStream ois=new ObjectInputStream(fis);
			h=(Hero) ois.readObject();
			ois.close();
			System.out.println("英雄数据读取成功");
			
		}catch(IOException e){
			System.out.println("英雄数据读取失败");
			e.printStackTrace();
		}
		return h;
	}
	//将BOSS数据保存在本地
	public static void writeBoss(Boss b){
		File file=new File("boss.dat");
		try{
			FileOutputStream fos=new FileOutputStream(file);
			//序列化对象
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(b);
			oos.flush();//清空缓冲区数据
			oos.close();
			System.out.println("Boss数据保存成功");
			
		}catch(IOException e){
			System.out.println("Boss数据保存失败");
			e.printStackTrace();
		}
	}
	//读取保存在本地的BOSS数据
	public static Boss readBoss() throws ClassNotFoundException{
		File file=new File("boss.dat");
		Boss b=new Boss();
		try{
			FileInputStream fis=new FileInputStream(file);
			//对象反序列化
			ObjectInputStream ois=new ObjectInputStream(fis);
			b=(Boss) ois.readObject();
			ois.close();
			System.out.println("BOSS数据读取成功");
			
		}catch(IOException e){
			System.out.println("BOSS数据读取失败");
			e.printStackTrace();
		}
		return b;
	}
	
	//将物品数据保存在本地
	public static void writeItems(Hero h){
		File file=new File("items.dat");
		try{
			FileOutputStream fos=new FileOutputStream(file);
			//序列化对象
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(h);
			oos.flush();//清空缓冲区数据
			oos.close();
			System.out.println("物品数据保存成功");
			
		}catch(IOException e){
			System.out.println("物品数据保存失败");
			e.printStackTrace();
		}
	}

	//读取保存在本地的物品数据
	public static void readItems(Hero h) throws ClassNotFoundException{
		File file=new File("items.dat");
		try{
			FileInputStream fis=new FileInputStream(file);
			//对象反序列化
			ObjectInputStream ois=new ObjectInputStream(fis);
			h=(Hero) ois.readObject();
			ois.close();
			System.out.println("物品数据读取成功");
			
		}catch(IOException e){
			System.out.println("物品数据读取失败");
			e.printStackTrace();
		}
//			return h;
	}
	

	
	
	

}
