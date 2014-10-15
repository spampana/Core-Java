package com.helpezee.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 Java didn�t comes with any ready make file copy function, 
 you have to manual create the file copy process. 
 
 To copy file, just convert the file into a bytes stream with 
 FileInputStream and write the bytes into another file with 
 FileOutputStream.

The overall processes are quite simple, just do not understand 
why Java doesn�t include this method into the java.io.File class.
 */
public class Copyafile {
	public static void main(String[] args)
    {	
 
    	InputStream inStream = null;
	OutputStream outStream = null;
 
    	try{
 
    	    File afile =new File("./Afile.txt");
    	    File bfile =new File("./Bfile.txt");
    	    
    	    bfile.createNewFile();
 
    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
 
    	    	outStream.write(buffer, 0, length);
 
    	    }
 
    	    inStream.close();
    	    outStream.close();
 
    	    System.out.println("File is copied successful!");
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
}
