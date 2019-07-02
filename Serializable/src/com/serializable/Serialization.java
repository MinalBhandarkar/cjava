package com.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serialization {

	
	public static void main(String[] args) {
		
		Serialization serial = new Serialization();
		serial.init();
		serial.write();
		serial.read();
			
	}
	
	File file=null;
	FootBallPlayer player;
	void init()
	{
		file= new File("data");
		player = new FootBallPlayer();
		player.setName("abc");
		player.setPos(5);
		player.setNationality("Indian");
			
	}
	
	 void write()
	{
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(player);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void read()
	{
		
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				FootBallPlayer player = (FootBallPlayer)objectInputStream.readObject();
				System.out.println(player);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	
	

}
