package com.exceptionHandling.fileOperations;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddContentsToFile 
{
	Scanner in = new Scanner(System.in);
	public void addTextContentToFile(String path)
	{
		System.out.println("Enter text to append the file: ");
		ArrayList<String> content = new ArrayList<String>();
		while (in.hasNextLine())
		{ 
			String read = in.nextLine();
			if(read == null || read.isEmpty())
			{ 
				break;  
			}
			content.add(read);
		}

		try {
			FileWriter fw = new FileWriter(path, true);
			for(String line : content)
			{
				fw.write(line);	
				fw.write("\r\n");
			}
			fw.close();
			System.out.printf("\nData saved successfully\nThe End");
		} 
		catch (IOException e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}
