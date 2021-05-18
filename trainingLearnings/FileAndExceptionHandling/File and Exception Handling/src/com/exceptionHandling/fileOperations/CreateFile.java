package com.exceptionHandling.fileOperations;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.exceptionHandling.DataValidator;
import com.exceptionHandling.OptOut;
import com.exceptionHandling.exceptions.CustomExceptions;

public class CreateFile 
{
	Scanner in = new Scanner(System.in);
	DataValidator dv = new DataValidator();
	OptOut obj = new OptOut();

	public void createFile() throws CustomExceptions
	{
		System.out.println("Enter the path where you want to create the file : ");
		String filePath = in.next();
		in.nextLine();
		File f = new File(filePath);
		if(f.exists())
		{
			String fileType = chooseFileType();
			System.out.println("Enter the file name : ");
			String fileName = in.nextLine();
			f = new File(filePath+"\\"+fileName+fileType);
			try {
				if(f.createNewFile())
					System.out.printf("\nFile created: " + f.getName()+"\nThe path of the file is "+f.getAbsolutePath()+"\n");
				else 
					System.out.println("File already exists.");
				obj.askOpen();
			} catch (IOException e) {
				System.out.println("Unable to create the file.. Try again");
				createFile();
			}
		}
		else
			throw new CustomExceptions("Invalid Directory");
	}

	String chooseFileType()
	{
		String fileTypes[] = {"DOC document", "Text Document","XLS Document","HTML file","JS file"};
		String extension[] = {".doc",".txt",".xls",".HTML",".js"};
		System.out.println("Choose a document type ");

		for(int i=0; i<fileTypes.length; i++)
		{
			System.out.println((i+1)+". "+fileTypes[i]);
		}
		int option = in.nextInt();
		try 
		{
			dv.validatePositiveLength(option,fileTypes.length);
		} 
		catch (CustomExceptions e) 
		{
			chooseFileType();
		}
		return extension[option-1];
	}
}
