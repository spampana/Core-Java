package com.helpezee.directory;

import java.io.File;

public class TraverseOrListadirectorystructure {
	public static void main (String args[]) {
		 
		displayIt(new File("C:\\Downloads"));
	}
 
	public static void displayIt(File node){
 
		System.out.println(node.getAbsoluteFile());
 
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				displayIt(new File(node, filename));
			}
		}
 
	}
}
