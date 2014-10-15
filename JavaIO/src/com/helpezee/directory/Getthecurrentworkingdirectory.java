package com.helpezee.directory;

public class Getthecurrentworkingdirectory {
	public static void main (String args[]) {
		 
		   String workingDir = System.getProperty("user.dir");
		   System.out.println("Current working directory : " + workingDir);
	 
	   }
}
