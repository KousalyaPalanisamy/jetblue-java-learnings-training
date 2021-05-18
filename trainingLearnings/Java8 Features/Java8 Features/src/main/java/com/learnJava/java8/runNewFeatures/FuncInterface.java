package com.learnJava.java8.runNewFeatures;

@FunctionalInterface
public interface FuncInterface 
{
	void abstractDisplay();
	static void statMethod()
	{
		System.out.println("In Static method");
	}
	default void end()
	{
		System.out.println("End of Functional Interface");
	}
}
