package com.exceptionHandling;

import java.util.Scanner;

import com.exceptionHandling.exceptions.CustomExceptions;
import com.exceptionHandling.fileOperations.CreateFile;
import com.exceptionHandling.fileOperations.EditFile;
import com.exceptionHandling.fileOperations.OpenFile;

public class OptOut {

	String yesNo;
	Scanner in = new Scanner(System.in);
	DataValidator dv = new DataValidator();
	CreateFile cf = new CreateFile();
	EditFile ef = new EditFile();
	OpenFile of = new OpenFile();
	void askCreate()
	{
		System.out.println("Do you want to create a file?  yes/no");
		String val = in.next();
		try 
		{	yesNo = dv.yesNoHandler(val);}
		catch (CustomExceptions e) {
			System.out.println(e);
			askCreate();
		}
		if(yesNo.equals("yes"))
		{
			try {
				cf.createFile();
			} catch (CustomExceptions e) {
				e.printStackTrace();
			}
		}
		else if(yesNo.equals("no"))
			askOpen();
	}
	public void askOpen()
	{
		System.out.println("Do you want to open any file? yes/no");
		String val = in.next();
		try 
		{	yesNo = dv.yesNoHandler(val);}
		catch (CustomExceptions e) {
			System.out.println(e);
			askOpen();
		}
		if(yesNo.equals("yes"))
		{
			System.out.println("Enter the path of the file which you want to open : ");
			of.openFile(in.next());
		}
		else if(yesNo.equals("no"))
			askEdit();
	}
	void askEdit()
	{
		System.out.println("Do you want to edit any file? yes/no");
		String val = in.next();
		try 
		{	yesNo = dv.yesNoHandler(val);}
		catch (CustomExceptions e) {
			System.out.println(e);
			askEdit();
		}
		if(yesNo.equals("yes"))
			ef.editFile();
		else if(yesNo.equals("no"))
			System.out.println("The end");
	}
	public static void main(String[] args) {

		OptOut obj = new OptOut();
		obj.askCreate();		
	}

}
