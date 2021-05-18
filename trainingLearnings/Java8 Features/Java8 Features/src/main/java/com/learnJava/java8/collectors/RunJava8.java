package com.learnJava.java8.collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learnJava.java8.model.SortWithComps;
import com.learnJava.java8.operations.ProgramOperationsInJava8;

/**
 * Hello world!
 *
 */
public class RunJava8 
{
	public static void main( String[] args )
	{
		ApplicationContext apc = new ClassPathXmlApplicationContext("beans.xml");

		ProgramOperationsInJava8 pogo = (ProgramOperationsInJava8)apc.getBean("OperationsOn8");
		pogo.run();
		System.out.println("\n----------------------------------------------------------------------------------\n");

		//		ProgramOperationsInJava8 pogo = (ProgramOperationsInJava8)apc.getBean("handleCollectors");
		//		pogo.run();
		//		OR

		HandleCollectors hand = (HandleCollectors)apc.getBean("handleCollectors");
		hand.run();
		System.out.println("\n----------------------------------------------------------------------------------\n");
		SortWithComps comps = (SortWithComps)apc.getBean("sort");
		System.out.println(comps);

	}
}
