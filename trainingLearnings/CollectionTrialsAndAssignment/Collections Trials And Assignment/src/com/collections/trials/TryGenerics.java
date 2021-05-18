package com.collections.trials;

import java.util.ArrayList;

class Laptop<T extends Number>
{
	int name;
	T type;
	public T show()
	{
		System.out.println("Name : "+name+" type : "+type+" type.getclass() : "+type.getClass());
		return type;
	}
	public void demo(ArrayList<? extends T> a)
	{

	}
}
public class TryGenerics<T> {

	public static void main(String[] args) {
		Laptop<Number> l = new Laptop<Number>();
		l.name = 3;
		l.type = 5;
		System.out.println(l.show());
		l.demo(new ArrayList<Number>());

	}

}
