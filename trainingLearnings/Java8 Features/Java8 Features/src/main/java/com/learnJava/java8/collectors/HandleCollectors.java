package com.learnJava.java8.collectors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.learnJava.java8.model.CollectionVariables;
import com.learnJava.java8.model.SortWithComps;
import com.learnJava.java8.operations.ProgramOperationsInJava8;

@Component
public class HandleCollectors implements ProgramOperationsInJava8 {

	void workWithCollectors(List<String> computerOperations)
	{
		System.out.println(computerOperations.stream().anyMatch(e -> e.startsWith("S")));

		System.out.println(computerOperations.stream().collect(Collectors
				.partitioningBy((String e) -> e.startsWith("S"))));
	}

	void employees(List<SortWithComps> emps)
	{
		System.out.println("Map of Employees whose Employee ID is greater than 1200");
		Map<Boolean,List<SortWithComps>> filteredEmployees = emps.parallelStream()
				.collect(Collectors.groupingBy((SortWithComps c) -> c.getEmployeeID()>1200));

		System.out.println(filteredEmployees+"\n");

		Map<SortWithComps, Boolean> finalList = new HashMap<>();
		//		= filteredEmployees.entrySet().stream().collect(HashMap::new, 
		//				(k,v)-> k.getValue().forEach(value -> finalList.put(value,v.getKey())), Map::putAll);


		for(Map.Entry<Boolean,List<SortWithComps>> mes : filteredEmployees.entrySet())
		{
			mes.getValue().forEach(l -> finalList.put(l, mes.getKey()));
		}
		finalList.forEach((k,v) -> System.out.println(k + " : "+v));
	}
	@Override
	public void run() {
		System.out.println("Handling Collectors");
		CollectionVariables cvr = new CollectionVariables();
		workWithCollectors(cvr.getArrayList2());
		employees(cvr.getArrayListOfTypeSortWithComps());
	}

}
