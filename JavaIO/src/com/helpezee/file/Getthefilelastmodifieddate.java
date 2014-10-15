package com.helpezee.file;

import java.io.File;
import java.text.SimpleDateFormat;

public class Getthefilelastmodifieddate {
	 public static void main(String[] args)
	    {	
		File file = new File("c:\\logfile.log");
	 
		System.out.println("Before Format : " + file.lastModified());
	 
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	 
		System.out.println("After Format : " + sdf.format(file.lastModified()));
	    }
}
