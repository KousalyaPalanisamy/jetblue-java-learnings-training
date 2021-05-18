package com.learnJava.java8.trials;

import java.util.Scanner;

interface Calculate
{
	public double algebraicExpressions(Double a, Double b);
}
public class Lambda 
{
	public static void main(String[] args) {
		Double x,y;
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a value for x: ");
		x = in.nextDouble();

		System.out.println("Enter a value for y: ");
		y = in.nextDouble();

		Calculate cal = (a,b) -> ((x*x)+(2*x*y)+(y*y));

		System.out.println("Value of (x+y)^2 is "+cal.algebraicExpressions(x,y));
		in.close();
	}

}
