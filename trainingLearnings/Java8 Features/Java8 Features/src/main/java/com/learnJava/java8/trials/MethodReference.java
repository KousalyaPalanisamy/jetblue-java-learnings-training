package com.learnJava.java8.trials;

public class MethodReference 
{
	static void doorOpen(String message)
	{
		System.out.println(message);
	}
	void doorClose(String comment)
	{
		System.out.println(comment);
	}
	static void ThreadPosition()
	{
		System.out.println("Thread is running");
	}
	public static void main(String[] args) {
		InterOperations op = MethodReference::doorOpen;
		op.open("Using a reference to a static method - Door Opened");

		op = new MethodReference()::doorClose;
		op.open("Using a reference to an instance method - Door Closed");

		op = ToConstructor::new;
		op.open("Using a reference to a Constructor");

		Thread t1 = new Thread(MethodReference::ThreadPosition);
		t1.start();
	}

}

class ToConstructor
{
	public ToConstructor(String msg) 
	{
		System.out.println(msg);
	}
}