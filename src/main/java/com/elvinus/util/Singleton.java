package com.elvinus.util;

public class Singleton {

	private static Singleton sing = null;
	
	public String s = "";
	
	private Singleton()
	{
		s = "This is me";
	}
	
	public static Singleton getInstance()
	{
		if(sing==null)
		{
			sing = new Singleton();
		}
		
		return sing;
	}
	
}



