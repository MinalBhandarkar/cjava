package com.serializable;

import java.io.Serializable;

public class FootBallPlayer implements Serializable
{
	private String name;
	private int pos;
	private String nationality;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	@Override
	public String toString() {
		return "FootBallPlayer [name=" + name + ", pos=" + pos + ", nationality=" + nationality + "]";
	}
	
	
}
