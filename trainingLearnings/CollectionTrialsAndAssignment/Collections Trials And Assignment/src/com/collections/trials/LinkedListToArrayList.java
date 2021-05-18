package com.collections.trials;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListToArrayList {

	public LinkedListToArrayList()
	{
		LinkedList link = new LinkedList();
		link.add("a1");
		link.add(2);
		link.add(true);
		link.add(45.0);
		System.out.println("ll"+link);

		ArrayList al = new ArrayList(link);
		System.out.println("array"+al);
	}
}

