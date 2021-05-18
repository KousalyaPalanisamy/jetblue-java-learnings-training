package com.collections.trials;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ReplaceAll<T> implements UnaryOperator<T> {

	T varA;
	@Override
	public T apply(T t) {
		return varA;
	}
}

class RemoveIf implements Predicate<String>
{
	String varB;
	@Override
	public boolean test(String varB1) {
		if(varB1.contains(varB))
		{
			return true;
		}
		return false;
	}

}