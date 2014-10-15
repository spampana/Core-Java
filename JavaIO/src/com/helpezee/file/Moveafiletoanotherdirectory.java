package com.helpezee.file;

import java.io.File;
/*
 Java.io.File does not contains any ready make move file method, 
 but you can workaround with the following two alternatives :

   a) File.renameTo().
   b) Copy to new file and delete the original file.
 */
public class Moveafiletoanotherdirectory {
	public static void main(String[] args)
    {	
    	try{
 
    	   File afile =new File("./Afile.txt");
 
    	   if(afile.renameTo(new File("../" + afile.getName()))){/*C:\\folderB\\" + afile.getName()*/
    		System.out.println("File is moved successful!");
    	   }else{
    		System.out.println("File is failed to move!");
    	   }
 
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
