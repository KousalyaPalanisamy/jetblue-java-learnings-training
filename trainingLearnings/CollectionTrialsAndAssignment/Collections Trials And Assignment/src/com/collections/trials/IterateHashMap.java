package com.collections.trials;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterateHashMap 
{
	public IterateHashMap()
	{
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); 

		hm.put("English marks", 54); 
		hm.put("Maths Marks", 80); 
		hm.put("History Marks", 82);

		System.out.println("HashMap: "+hm);

		Iterator hmIt = hm.entrySet().iterator(); 
		while (hmIt.hasNext()) 
		{ 
			Map.Entry element = (Map.Entry)hmIt.next(); 
			int marks = ((int)element.getValue() + 10); 
			System.out.println(element.getKey() + " : " + marks); 
		} 


	}
}
