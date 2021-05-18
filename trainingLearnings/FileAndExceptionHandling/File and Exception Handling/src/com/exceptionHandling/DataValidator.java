package com.exceptionHandling;

import java.util.Scanner;

import com.exceptionHandling.exceptions.CustomExceptions;
import com.exceptionHandling.fileOperations.AddContentsToFile;

public class DataValidator 
{
	Scanner in = new Scanner(System.in);
	AddContentsToFile addContents = new AddContentsToFile();

	String yesNoHandler(String value) throws CustomExceptions 
	{
		if(value.equalsIgnoreCase("yes"))
			return "yes";
		else if(value.equalsIgnoreCase("no"))
			return "no";
		else
			throw new CustomExceptions("Invalid Option.. Try Again");
	}

	public boolean validatePositiveLength(int option, int length) throws CustomExceptions
	{
		if(option<1 || option >length)
			throw new CustomExceptions("Invalid option");
		else
			return true;
	}

	public void validateExtension(String FilePath)
	{
		String extension = FilePath.substring(FilePath.lastIndexOf(".")+1, FilePath.length());
		switch(extension)
		{
		case "txt" : 
		case "text" : addContents.addTextContentToFile(FilePath);
		break;
		default : System.out.println("Invalid File Type");
		}
	}
}




