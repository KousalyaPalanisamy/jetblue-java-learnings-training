package collection.trials;

public class SortWithComps implements Comparable<SortWithComps>
{
	String employeeName;
	int employeeID;
	String employeeDesignation;

	public SortWithComps(int empID, String empName, String empDesig)
	{
		this.employeeName = empName;
		this.employeeDesignation = empDesig;
		this.employeeID = empID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	@Override
	public String toString()
	{
		return "[ Employee ID = "+employeeID+", Employee Name = "+employeeName+", Employee Designation = "+employeeDesignation+" ]";
	}

	@Override
	public int compareTo(SortWithComps compare) 
	{ 
		return this.employeeID-compare.getEmployeeID();
	}



}
