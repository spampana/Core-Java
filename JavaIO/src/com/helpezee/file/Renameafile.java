package com.helpezee.file;

import java.io.File;

public class Renameafile {
	public static void main(String[] args)
    {	
 
		File oldfile =new File("./oldfile.txt");
		File newfile =new File("./newfile.txt");
 
		if(oldfile.renameTo(newfile)){
			System.out.println("Rename succesful");
		}else{
			System.out.println("Rename failed");
		}
 
    }
}
