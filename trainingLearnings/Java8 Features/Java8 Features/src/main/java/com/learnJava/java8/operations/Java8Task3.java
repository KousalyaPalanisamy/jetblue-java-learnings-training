package com.learnJava.java8.operations;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Java8Task3 {

	public void task3List(List<Integer> lis)
	{
		System.out.println("\n\nGiven List is \n"+lis);
		System.out.println("\nThe list of filtered values which are above 10 and below 20 is \n"+
				lis.stream().filter(element -> element>10 && element<20).collect(Collectors.toList()));
		System.out.println("-------------------------------------------------------------------------------");
	}

	public void task3Map(Map<Integer,String> mp)
	{
		System.out.println("\n\nGiven Map is \n"+mp);
		System.out.println("\nThe map of filtered values, whose keys are more than 500 is \n"+
				mp.entrySet().stream().filter(j -> j.getKey() > 500).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

		//		System.out.println("\nThe map of filtered values, whose keys are more than 500 is ");
		//		mp.entrySet().stream().filter(j -> j.getKey() > 500).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).forEach((k,v) -> System.out.print(k+" = "+v+" "));
		System.out.println("-------------------------------------------------------------------------------");
	}

	public void consumerSupplier(List<Integer> lis)
	{
		System.out.println("\n\nUsing Consumers and suppliers\nGiven List is");
		lis.stream().forEach((e)->	print(()-> e));
		Consumer<Integer> cn = (i) ->{
			if(i>10 && i<20)
				System.out.printf("\n"+i+" is filtered");
		};

		lis.stream().forEach(cn);
		System.out.println("\n-------------------------------------------------------------------------------");
	}

	private void print(Supplier<Integer> supplier) {
		System.out.print(supplier.get()+" ");
	}
}
