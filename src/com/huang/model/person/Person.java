package com.huang.model.person;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Person implements Serializable {

	private String name; //姓名
	private int blood;//血量
	private int magic;//魔法值
	private int PhysicalDefend;//物理防御
	private int MagicDefend;//魔法防御
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	public int getMagic() {
		return magic;
	}
	public void setMagic(int magic) {
		this.magic = magic;
	}
	public int getPhysicalDefend() {
		return PhysicalDefend;
	}
	public void setPhysicalDefend(int physicalDefend) {
		PhysicalDefend = physicalDefend;
	}
	public int getMagicDefend() {
		return MagicDefend;
	}
	public void setMagicDefend(int magicDefend) {
		MagicDefend = magicDefend;
	}
	
	
}
