package com.collections.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperationsOnList 
{
	public void sortWithComps(List<SortWithComps> a)
	{
		System.out.println("Given ArrayList: ");
		printArrayList(a);

		System.out.println("\n1. Using Comparator to Sort based on Employee ID\n");
		Collections.sort(a,Comps.comptEmpid);
		printArrayList(a);

		System.out.println("\n2. Using Comparator to Sort based on Employee Name\n");
		Collections.sort(a,Comps.comptEmpName);
		printArrayList(a);

		System.out.println("\n3. Using Comparable to Sort based on Employee ID\n");
		Collections.sort(a);
		printArrayList(a);
	}

	public void printArrayList(List<SortWithComps> a)
	{
		a.forEach(System.out::println);
	}

	public void descendingSort(List<? extends Object> a) //if class type is used, then the return type in Collection Variables should be altered
	{								//all class extends Object class by default. so this can be used
		try 
		{
			System.out.println("Given ArrayList :"+a);
			Collections.sort(a, Collections.reverseOrder());
			System.out.println("Decending Order : "+a);
		}
		catch(ClassCastException e)
		{
			List<String> newArray = new ArrayList<>();
			a.forEach(ele -> newArray.add(String.valueOf(ele)));
			descendingSort(newArray);
		}
	}

	public void reverseArrayList(List<? extends Object> a) 
	{
		System.out.println("Given ArrayList: "+a);
		Collections.reverse(a);
		System.out.println("Reversed ArrayList: "+a);
	}

	public void linkedListToArrayList(List<? extends Object> a)
	{
		System.out.println("Given LinkedList: "+a);
		ArrayList<?> al = new ArrayList<>(a);
		System.out.println("Converted ArrayList : "+al);
	}
}

/*
class name as type - when the method needs to be restricted for the collections that are not 
received from the specified class

 */