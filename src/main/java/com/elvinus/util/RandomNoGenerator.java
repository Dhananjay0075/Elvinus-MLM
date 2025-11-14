package com.elvinus.util;

import java.util.Random;

public class RandomNoGenerator {

	public static int generatePin() throws Exception {
		
			Random generator = new Random();
			generator.setSeed(System.currentTimeMillis());
			  
			int num = generator.nextInt(99999) + 99999;
			
			if (num < 100000 || num > 999999) {
			num = generator.nextInt(99999) + 99999;
			if (num < 100000 || num > 999999) {
			  throw new Exception("Unable to generate PIN at this time..");
			}
			
			}
			return num;			
	}
	
	public static void main(String atr[]) throws Exception
	{
		System.out.println("Current random number="+generatePin());
	}
	
}
