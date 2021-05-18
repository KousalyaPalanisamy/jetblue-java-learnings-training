package com.collections.operations;

public class EqualsAndHashCode 
{
	String employeeID;

	public EqualsAndHashCode(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public int hashCode() {
		System.out.println("in hashcode");
		System.out.println(employeeID);
		return this.employeeID.hashCode();
		/*
		 * final int prime = 31; 
		 * int result = 1; 
		 * result = prime * result + ((employeeID == null) ? 0 : employeeID.hashCode()); 
		 * return result;
		 */
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("in equals");
		if(obj instanceof EqualsAndHashCode)
		{
			String id = ((EqualsAndHashCode)obj).getEmployeeID();
			if(id != null && id.equals(this.getEmployeeID()))
			{
				return true;
			}
		}
		return false;
		/*
		 * if (this == obj) return true; if (obj == null) return false; if (getClass()
		 * != obj.getClass()) return false; EqualsAndHashCode other =
		 * (EqualsAndHashCode) obj; if (employeeID == null) { if (other.employeeID !=
		 * null) return false; } else if (!employeeID.equals(other.employeeID)) return
		 * false; return true;
		 */
	}



}
