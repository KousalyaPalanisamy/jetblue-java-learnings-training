package collection.trials;

import java.util.Comparator;

public class Comps 
{

	public static Comparator<SortWithComps> comptEmpid = new Comparator<SortWithComps>() {

		@Override
		public int compare(SortWithComps s1, SortWithComps s2) 
		{
			//ascending order
			return s1.getEmployeeID()-s2.getEmployeeID();

			//For descending order
			//return s2.getEmployeeID()-s1.getEmployeeID();
		}
	};

	public static Comparator<SortWithComps> comptEmpName = new Comparator<SortWithComps>() {

		@Override
		public int compare(SortWithComps s1, SortWithComps s2) 
		{
			//ascending order
			return s1.getEmployeeName().compareTo(s2.getEmployeeName());

			//For descending order
			//return s2.getEmployeeName().compareTo(s1.getEmployeeName());
		}
	};

}
