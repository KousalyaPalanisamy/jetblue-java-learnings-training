package com.exceptionHandling.fileOperations;

import java.awt.Desktop;
import java.io.File;

public class OpenFile 
{
	public void openFile(String path)
	{
		try  
		{    
			File ofile = new File(path);   
			if(!Desktop.isDesktopSupported())	  
			{  
				System.out.println("not supported");  
				return;  
			}  
			Desktop desktop = Desktop.getDesktop();  
			if(ofile.exists())          
				desktop.open(ofile);
		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}  
	}
}
