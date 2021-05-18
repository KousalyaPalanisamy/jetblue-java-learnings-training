package com.exceptionHandling.fileOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.exceptionHandling.DataValidator;

public class EditFile 
{
	Scanner in = new Scanner(System.in);
	DataValidator dv = new DataValidator();

	public void editFile()
	{
		System.out.println("Enter the path of the file which you want to edit : ");
		String filePath = in.next();
		try 
		{
			FileInputStream fis = new FileInputStream(filePath);	//FileNotfoundexception
			System.out.println("File content ");
			System.out.println("----------------------------------------------------------------------------");
			int r=0;  
			while((r=fis.read())!=-1)  	//IOException
			{  
				System.out.print((char)r);        
			} 
			System.out.printf("\n----------------------------------------------------------------------------\n");

			dv.validateExtension(filePath);
		} 
		catch(FileNotFoundException e)
		{
			System.out.println("File not available");
			editFile();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

}
