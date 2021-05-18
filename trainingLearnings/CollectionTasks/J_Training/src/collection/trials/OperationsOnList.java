package collection.trials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class OperationsOnList 
{
	public void sortWithComps(ArrayList a)
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

	public void printArrayList(ArrayList<?> a)
	{
		for(Object it : a)
		{
			System.out.println(it);
		}
	}
	public void descendingSort(ArrayList<?> a)
	{
		try 
		{
			System.out.println("Given ArrayList :"+a);
			Collections.sort(a, Collections.reverseOrder());
			System.out.println("Decending Order : "+a);
		}
		catch(ClassCastException e)
		{
			System.out.printf("\nThe specified Collection have data of different types. \n"+
					"So the above Collection cannot be sorted\n\n");
		}
	}

	public void reverseArrayList(ArrayList<?> a)
	{
		System.out.println("Given ArrayList: "+a);
		Collections.reverse(a);
		System.out.println("Reversed ArrayList: "+a);
	}

	public void linkedListToArrayList(LinkedList<?> a)
	{
		System.out.println("Given LinkedList: "+a);
		ArrayList al = new ArrayList(a);
		System.out.println("Converted ArrayList : "+al);
	}



}
