package com.learnJava.java8.trials;

import org.eclipse.jdt.annotation.NonNull;

@CollegeInfo(collegeCode = "U8NGP")
@CollegeInfo(collegeName = "Dr.NGP Arts and Science College",university = "Bharathiyar University")
//@CollegeInfo.Games(values = { @Game(gameName = "Hockey") })
public class ListData
{
	@NonNull String studentName;

	public ListData() {}
	public ListData(@NonNull String studentName) {
		this.studentName = studentName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
/*
ListData ld = new ListData();
@NonNull List<ListData> data = new LinkedList<>();
data.add(new ListData("Charles"));

//Class<? extends ListData> c = ld.getClass();//reflection api to get the values/features of the object
Annotation an = ld.getClass().getAnnotation(CollegeInfo.class);
CollegeInfo ci = (CollegeInfo)an;	
System.out.println(ci.collegeName());
 */