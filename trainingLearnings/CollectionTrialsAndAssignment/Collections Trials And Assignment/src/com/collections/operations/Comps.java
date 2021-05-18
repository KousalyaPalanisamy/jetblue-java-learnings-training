package com.collections.operations;

import java.util.Comparator;

public final class Comps {
	private Comps()	{//not called
	}

	public static final Comparator<SortWithComps> comptEmpid = (SortWithComps s1, SortWithComps s2) ->  s1.getEmployeeID() - s2.getEmployeeID();


	public static final Comparator<SortWithComps> comptEmpName = (SortWithComps s1, SortWithComps s2) -> s1.getEmployeeName().compareTo(s2.getEmployeeName());


}
