package com.helpezee.file;

import java.io.File;
import java.io.IOException;

public class Makeafilereadonly {
	public static void main(String[] args) throws IOException
    {	
    	File file = new File("./newFile.txt");
 
    	//mark this file as read only, since jdk 1.2
    	file.setReadOnly();
 
    	if(file.canWrite()){
    	     System.out.println("This file is writable");
    	}else{
    	     System.out.println("This file is read only");
    	}
 
    	//revert the operation, mark this file as writable, since jdk 1.6
    	file.setWritable(true);
 
    	if(file.canWrite()){
    	     System.out.println("This file is writable");
    	}else{
    	     System.out.println("This file is read only");
    	}   	
    }
}
