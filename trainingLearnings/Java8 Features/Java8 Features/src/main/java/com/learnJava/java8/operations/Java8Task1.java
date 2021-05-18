package com.learnJava.java8.operations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Task1 
{
	public void fetchOddAndEven(List<Integer> lis)
	{
		System.out.println("Given List is \n"+lis);
		System.out.println("\n1. Using Consumer and forEach() filtering Even and Odd");
		Consumer<Integer> cn = (i) ->{
			if(i%2==0)
				System.out.println(i+" is Even");
			else
				System.out.println(i+" is Odd");
		};
		lis.forEach(cn);
		System.out.println("-------------------------------------------------------------------------------");

		System.out.println("\n2. Using filter()\n"+
				"\nEven elements are "+lis.stream().filter(n -> n%2==0).collect(Collectors.toList())+
				"\nOdd elements are "+lis.stream().filter(n -> n%2!=0).collect(Collectors.toList()));

		System.out.println("-------------------------------------------------------------------------------");
		int normalArray[] = {12,49,53,68,94,17};
		Arrays.parallelSort(normalArray);
		System.out.println("\n3. Filtering from a normal array\nGiven Array is "+Arrays.toString(normalArray));

		IntStream strm = Arrays.stream(normalArray);
		System.out.println("\nEven elements are");
		strm.filter(n -> n%2==0).forEach(System.out::println);

		//		System.out.println("\nOdd elements are");
		//		strm.filter(n -> n%2!=0).forEach(System.out::println);
		System.out.println("-------------------------------------------------------------------------------");
	}
}
