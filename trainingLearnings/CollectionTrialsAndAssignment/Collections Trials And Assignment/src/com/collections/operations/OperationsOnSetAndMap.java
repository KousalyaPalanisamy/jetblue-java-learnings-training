package com.collections.operations;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;

public class OperationsOnSetAndMap 
{
	public void findElementInHashSet(Set<? extends Object> hs)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Given HashSet was "+hs);
		System.out.println("Enter an element to search the HashSet: ");
		String element = in.nextLine();

		if(hs.contains(element))
			System.out.println("The element "+element+" is available in the HashSet");
		else
			System.out.println("The element "+element+" is not available in the HashSet");
		System.out.println("Given HashSet was "+hs);

		in.close();

	}

	public void iterateTreeMap(SortedMap<? extends Object, ? extends Object> tm)
	{
		System.out.println("Given TreeMap: "+tm);

		System.out.println("\n1. Using Enhanced For-Loop\n");
		for(Map.Entry<?, ?> element : tm.entrySet())
		{
			System.out.println("[ "+element.getKey()+" = "+element.getValue()+" ]");
		}

		System.out.println("\n2. Using forEach of HashMap\n");
		tm.forEach((key,value) -> System.out.println(key + " : "+value));
	}

	public void iterateHashMap(Map<String,Integer> hm)
	{
		System.out.println("Given HashMap: "+hm);

		System.out.println("1. Using Iterator interface");
		Iterator<Entry<String, Integer>> hmIt = hm.entrySet().iterator(); 
		while (hmIt.hasNext()) 
		{ 
			Map.Entry<String, Integer> element = hmIt.next(); 
			System.out.println(element.getKey() + " : " + element.getValue()); 
		} 

		System.out.println("\n2. Using Enhanced For-Loop\n");
		for(Map.Entry<String, Integer> ash : hm.entrySet())
			System.out.println(ash.getKey() + " : " + ash.getValue());

		System.out.println("\n3. Using forEach of HashMap\n");
		hm.forEach((key,value) -> System.out.println(key + " : "+value));

	}
}
//override hash code and equals