package com.helpezee.file;

import java.io.File;

public class Checkifafileexists {
	public static void main(String args[]) {
		 
		  File f = new File("./newFile.txt");
	 
		  if(f.exists()){
			  System.out.println("File existed");
		  }else{
			  System.out.println("File not found!");
		  }
	 
	  }
}
