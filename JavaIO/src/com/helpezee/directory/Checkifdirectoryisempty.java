package com.helpezee.directory;

import java.io.File;

public class Checkifdirectoryisempty {
	public static void main(String[] args)
    {	
 
	File file = new File("C:\\folder");
 
	if(file.isDirectory()){
 
		if(file.list().length>0){
 
			System.out.println("Directory is not empty!");
 
		}else{
 
			System.out.println("Directory is empty!");
 
		}
 
	}else{
 
		System.out.println("This is not a directory");
 
	}
    }
}
