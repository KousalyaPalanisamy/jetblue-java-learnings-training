package com.collections.trials;

import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.Spliterator;
import java.util.TreeMap;

public class TryRareMethods 
{
	void arrayListOperations()
	{
		ArrayList<String> arl = new ArrayList<>();
		arl.add("hibernate");
		arl.add("Shut down");
		arl.add("Restart");
		arl.add("abnormal");
		arl.add("Sleep");
		arl.add("Switch User");

		ArrayList<String> arl1 = new ArrayList<>();
		arl1.add("hibernate");
		arl1.add("Shut down");
		arl1.add("new element");

		arl.retainAll(arl1);
		System.out.println("Using retain All for arl from arl1");
		System.out.println("list 1 : "+arl);
		System.out.println("list 2 : "+arl1);

		ReplaceAll<String> repa = new ReplaceAll<>();
		repa.varA = "system operations";

		arl1.replaceAll(repa);
		System.out.println("Using Replace All for arl1: "+arl1);

		RemoveIf filter = new RemoveIf();
		filter.varB = "ber";
		arl.removeIf(filter);
		System.out.println("Using Remove If for arl: "+arl);

		ArrayList<Integer> arlint = new ArrayList<>();
		arlint.add(23);
		arlint.add(89);
		arlint.add(45);

		Spliterator<Integer> spr = arlint.spliterator();
		System.out.println(spr.characteristics());
	}

	void treeMapOperations()
	{
		NavigableMap<Integer, String> treemap = new TreeMap<>();

		treemap.put(2, "two");
		treemap.put(1, "one");
		treemap.put(3, "three");
		treemap.put(6, "six");
		treemap.put(5, "five");
		System.out.println(treemap);

		//The ceilingEntry(K key) method is used to return a key-value mapping associated with the least key greater than or equal to the given key, or null if there is no such key
		System.out.println("\nCeiling entry for 4: "+ treemap.ceilingEntry(4));
		System.out.println("Ceiling entry for 5: "+ treemap.ceilingEntry(5));

		//The ceilingKey(K key) method is used to return the least key greater than or equal to the given key, or null if there is no such key.
		System.out.println("\nCeiling key entry for 4: "+ treemap.ceilingKey(4));
		System.out.println("Ceiling key entry for 5: "+ treemap.ceilingKey(5));
		System.out.println("Ceiling key entry for 7: "+ treemap.ceilingKey(7));



	}
	public static void main(String[] args)
	{
		TryRareMethods trm = new TryRareMethods();
		//trm.arrayListOperations();
		trm.treeMapOperations();

	}
}
