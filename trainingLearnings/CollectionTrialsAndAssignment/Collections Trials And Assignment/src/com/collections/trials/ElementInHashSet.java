package com.collections.trials;

import java.util.HashSet;
import java.util.Scanner;

public class ElementInHashSet 
{
	void findElement()
	{
		HashSet hs = new HashSet();
		hs.add("Navarre");
		hs.add("Scotland");
		hs.add("Chennai");
		hs.add("Yeman");
		hs.add("641664");

		System.out.println("Enter an element to search the HashSet: ");
		Scanner in = new Scanner(System.in);
		String element = in.nextLine();
		if(hs.contains(element))
			System.out.println("The element "+element+" is available in the HashSet");
		else
			System.out.println("The element "+element+" is not available in the HashSet");
	}
}
