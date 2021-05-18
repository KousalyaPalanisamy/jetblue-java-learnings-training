package com.collections.trials;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseArrayList 
{
	public ReverseArrayList()
	{
		ArrayList arl = new ArrayList();
		arl.add("a1");
		arl.add(2);
		arl.add(true);
		arl.add(45.0);
		arl.add("true");
		arl.add(92);

		System.out.println("ArrayList "+arl);
		Collections.reverse(arl);
		System.out.println(arl);

		arl.clear();
		arl.add("hibernate");
		arl.add("Shut down");
		arl.add("Restart");
		arl.add("Sleep");
		arl.add("Switch User");

		System.out.println("ArrayList "+arl);
		Collections.reverse(arl);
		System.out.println(arl);
	}
}
