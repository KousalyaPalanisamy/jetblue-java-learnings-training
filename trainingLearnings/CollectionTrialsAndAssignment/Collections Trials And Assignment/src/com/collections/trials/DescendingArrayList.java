package com.collections.trials;

import java.util.ArrayList;
import java.util.Collections;

public class DescendingArrayList {

	public DescendingArrayList()
	{
		ArrayList<Comparable> arl = new ArrayList();
		arl.add("a1");
		arl.add(2);
		arl.add(true);
		arl.add(45.0);
		arl.add("true");
		arl.add(92);

		descendingsort(arl);

		arl.clear();
		arl.add("hibernate");
		arl.add("Shut down");
		arl.add("Restart");
		arl.add("Sleep");
		arl.add("Switch User");

		descendingsort(arl);
	}
	void descendingsort(ArrayList a)
	{
		try 
		{
			System.out.printf("ArrayList :"+a+"\n");
			Collections.sort(a, Collections.reverseOrder());
			System.out.println(a);
		}
		catch(ClassCastException e)
		{
			System.out.printf("\nData of the Collection specified are of different types. \n"+
					"So the Collection cannot be sorted\n\n");
		}
	}

}
