package com.elvinus.util;

import java.util.HashMap;
import java.util.Map;

public class CreditCalculation {

	public static int getReferenceCreditReward(int refCount)
	{
		if(refCount>0 && refCount<21)
		{
			int perCount = refCount/5;
			return creditReward(perCount);
		}
		else if(refCount>20 && refCount<41)
		{
			int perCount = (refCount-20)/5;
			return creditReward(perCount);
		}
		else if(refCount>40 && refCount<61)
		{
			int perCount = (refCount-40)/5;
			return creditReward(perCount);
		}
		else
		{
			return 0;
		}		
	}
	
	public static int creditReward(int perCount)
	{
		int reward = 0;
		
		if(perCount==0)
		{
			reward = 10;			
		}
		else if(perCount==1)
		{
			reward = 8;
		}
		else if(perCount==2)
		{
			reward = 5;
		}
		else if(perCount==3)
		{
			reward = 3;
		}
		else
		{
			reward = 0;
		}
		
		return reward;
	}
	
	
	/// REWARD POINT
	
	public static int getParentRewardPoint(int refCount)
	{
		if(refCount>0 && refCount<21)
		{
			int perCount = refCount/5;
			return creditRewardPoint(perCount);
		}
		else if(refCount>20 && refCount<41)
		{
			int perCount = (refCount-20)/5;
			return creditRewardPoint(perCount);
		}
		else if(refCount>40 && refCount<61)
		{
			int perCount = (refCount-40)/5;
			return creditRewardPoint(perCount);
		}
		else
		{
			return 0;
		}	
	}
	
	public static int creditRewardPoint(int perCount)
	{
		int reward = 0;
		
		if(perCount==0)
		{
			reward = 1;			
		}
		else if(perCount==1)
		{
			reward = 3;
		}
		else if(perCount==2)
		{
			reward = 6;
		}
		else if(perCount==3)
		{
			reward = 10;
		}
		else
		{
			reward = 0;
		}
		
		return reward;
	}
}
