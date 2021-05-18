package com.collections.trials;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class IterateTreeMap 
{
	public IterateTreeMap()
	{
		LinkedList ls = new LinkedList();
		Map<String, String> tmap = new TreeMap();
		tmap.put("Name", "Henry");
		tmap.put("Height", "6.1 feet");
		tmap.put("Birth Place", "France");

		ls.add(tmap);

		for(Map.Entry<String, String> element : tmap.entrySet())
		{
			System.out.println("[ "+element.getKey()+" = "+element.getValue()+" ]");
		}

	}
}

//incomplete	