package com.collections.exceptions;

public class CustomExceptions extends Exception
{
	String message;
	public CustomExceptions(String msg) 
	{
		this.message = msg;
	}
	@Override
	public String toString()
	{
		return message;
	}
}
