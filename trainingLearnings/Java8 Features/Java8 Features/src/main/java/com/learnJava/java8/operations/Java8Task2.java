package com.learnJava.java8.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//difference and common elements
public class Java8Task2 
{
	public void commonElements(List<? extends Object> list1, List<? extends Object> list2)
	{
		System.out.println("List1 : "+list1+"\nList2 : "+list2);
		System.out.println("\n1. Using retain all method");
		list1.retainAll(list2);
		System.out.println("The common elements in both the lists are \n"+list1);

		List<String> list3 = new ArrayList<>();
		System.out.println("\n2. Using contains method");
		for(int i = 0; i<list1.size();i++)
		{
			if(list2.contains(list1.get(i)))
				list3.add(list1.get(i).toString());
		}
		System.out.println("The common elements in both the lists are \n"+list3);

		System.out.println("\n3. Using Stream API filter method");
		System.out.println("The common elements in both the lists are \n"+
				list1.stream().filter(list2::contains).collect(Collectors.toList()));

		System.out.println("-------------------------------------------------------------------------------");
	}

	public void differentElements(List<String> list1, List<String> list2)
	{
		System.out.println("List1 : "+list1+"\nList2 : "+list2);
		System.out.println("\n1. Using filter method");
		List<String> list3 = list1.stream().filter(element -> !list2.contains(element)).collect(Collectors.toList());
		list3.addAll(list2.stream().filter(element -> !list1.contains(element)).collect(Collectors.toList()));
		System.out.println("The different ements from the lists are \n"+list3);

		System.out.println("\n2. Using removeIf method");
		List<String> list4 = new ArrayList<>(list1);
		list4.removeIf(e -> list2.contains(e));
		for(String ele : list2)
		{
			if(!list1.contains(ele))
				list4.add(ele);
		}
		System.out.println("The different ements from the lists are \n"+list4);

		System.out.println("-------------------------------------------------------------------------------");
	}
}

/*
list1.stream().flatMap(i -> Stream.of(i)).filter(e -> {
if(list2.contains(e) == false)
	list3.add(e.toString());
});

System.out.println(list1);

 */