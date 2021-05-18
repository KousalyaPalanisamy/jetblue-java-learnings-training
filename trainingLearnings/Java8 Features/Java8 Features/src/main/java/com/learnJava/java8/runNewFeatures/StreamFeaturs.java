package com.learnJava.java8.runNewFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.learnJava.java8.model.CollectionVariables;
import com.learnJava.java8.operations.Java8Task1;
import com.learnJava.java8.operations.Java8Task2;
import com.learnJava.java8.operations.Java8Task3;

public class StreamFeaturs {

	private void useConsumerInterface(List<String> lis)
	{
		Consumer<String> cn = System.out::println;
		lis.forEach(cn);

		Consumer<String> stringConsumer = (s) -> System.out.println(s.length());
		Arrays.asList("ab", "abc", "a", "abcd").stream().forEach(stringConsumer);
	}

	void streamMap(Map<Integer,String> mp)
	{
		System.out.println(mp.entrySet().stream().map(i -> i).filter(j -> j.getKey()>500).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
		//System.out.println(ops);
		//System.out.println(mp.stream());
	}


	public static void main(String[] args) {

		Java8Task1 jtask1 = new Java8Task1();
		Java8Task2 jtask2 = new Java8Task2();
		Java8Task3 jtask3 = new Java8Task3();
		CollectionVariables cvr = new CollectionVariables();

		jtask1.fetchOddAndEven(cvr.getArrayList3());

		jtask2.commonElements(cvr.getArrayList2(), cvr.getArrayList4());
		jtask2.differentElements(cvr.getArrayList2(), cvr.getArrayList4());

		jtask3.task3List(cvr.getArrayList3());
		jtask3.task3Map(cvr.getHashMap2());
		jtask3.consumerSupplier(cvr.getArrayList3());
		StreamFeaturs mrn = new StreamFeaturs();
		//		mrn.useConsumerInterface(cvr.getArrayList2());
		//		mrn.streamMap(cvr.getHashMap2());



	}

}























/*
Java 8 Features - https://www.javatpoint.com/java-8-features

--	1	Lambda Expressions		Lambda.java
--	2	Method References		MethodReference.java
--	3	Functional Interfaces	FuncInterface.java
	4	Stream API
	5	Stream Filter
	6	Base64 Encode Decode
--	7	Default Methods
--	8	forEach() method
	9	Collectors class
	10	StringJoiner class
	11	Optional class
	12	JavaScript Nashorn
	13	Parallel Array Sort
	14	Type Inference
	15	Parameter Reflection
--	16	Type Annotations		
	17	JDBC Improvements
 */