package com.learnJava.java8.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap implements ProgramOperationsInJava8
{
	List<Integer> prime = Arrays.asList(5, 7, 11,13); 
	List<Integer> odd = Arrays.asList(1, 3, 5); 
	List<Integer> even = Arrays.asList(2, 4, 6, 8); 

	void mapVsFlatmap()
	{
		List<List<Integer>> combined =  Arrays.asList(prime, odd, even);
		System.out.println("Before using flatmap : \n"+combined);

		//		System.out.println(combined.stream().filter(e -> (e>6 && e<15)));
		System.out.println("\nFiltered list without using flatmap");

		combined.stream()
		.forEach(i -> System.out.println(i.stream().filter(e -> (e>6 && e<15)).collect(Collectors.toList())));

		System.out.println("\nAfter using flatmap : \n"+combined.stream()
		.flatMap(List::stream).collect(Collectors.toList()));

		System.out.println("\nFiltered list using flatmap "+combined.stream()
		.flatMap(List::stream).filter(e -> (e>6 && e<15)).collect(Collectors.toList()));
	}


	@Override
	public void run() 
	{
		mapVsFlatmap();
	}
}

/*
void map(List<SortWithComps> podA, List<SortWithComps> podB, List<SortWithComps> podC)
{
	Map<String, List<SortWithComps>> studentInfo = new LinkedHashMap<>();
	studentInfo.put("Pod A",podA);
	studentInfo.put("Pod C",podC);
	studentInfo.put("Pod B",podB);

	studentInfo.forEach((k,v) -> System.out.println(k + " : " + v));
}
 */