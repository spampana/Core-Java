package com.helpezee.file;

import java.io.File;
import java.io.IOException;
/*
 Note
The isHidden() method is system dependent,
 on UNIX platform, a file is considered hidden if it’s name is begins with a “dot” symbol (‘.’); 
 On Microsoft Windows platform, a file is considered to be hidden, if it’s marked as hidden in the file properties.
 */
public class Checkifafileishidden {
	public static void main(String[] args) throws IOException
    {	
    	File file = new File("./newFile.txt");
 
    	if(file.isHidden()){
    		System.out.println("This file is hidden");
    	}else{
    		System.out.println("This file is not hidden");
    	}
    }
}
