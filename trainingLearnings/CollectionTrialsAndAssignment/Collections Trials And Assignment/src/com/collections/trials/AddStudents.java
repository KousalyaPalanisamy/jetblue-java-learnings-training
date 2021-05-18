package com.collections.trials;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class AddStudents {

	Scanner in = new Scanner(System.in);

	LinkedList<Map> studentDb = new LinkedList();
	Map<String, Comparable> student = new HashMap();
	public void addStudents() {
		String keys[] = { "Student Name", "Grade", "English marks", "Maths marks", "History marks" };

		System.out.println("Enter the number of students data you want to enter: ");
		int numberOfStudents = in.nextInt();
		in.nextLine();
		for (int i = 0; i < numberOfStudents; i++) 
		{

			double total = 0,marks;
			String text;
			student.put("Student ID", i + 1);
			for (int j=0;j<keys.length;j++) 
			{
				System.out.println("Enter " + keys[j]);
				if(keys[j].endsWith("marks"))
				{	
					try{
						marks = getDoubleInput();
						student.put(keys[j], marks);
					}
					catch(InputMismatchException e)
					{
						System.out.println("Invalid Input.. Enter an integer for "+keys[j]);
						marks = getDoubleInput();
						student.put(keys[j], marks);
						//						j--;
						//						continue;
					}
				}
				else
				{	
					student.put(keys[j], in.nextLine());
				}
			}
			for (int j = 2; j <= 4; j++) 
			{
				total += (double) student.get(keys[j]);
			}
			System.out.println(total);
			studentDb.add(student);
			student.clear();
			in.nextLine();
		}
		System.out.println(studentDb);

	}

	double getDoubleInput()
	{
		return in.nextDouble();
	}

}
