package com.helpezee.file;

import java.io.File;
import java.io.FileInputStream;

public class ConvertFileintoanarrayofbytes {
	public static void main( String[] args )
    {
    	FileInputStream fileInputStream=null;
 
        File file = new File("./newFile.txt");
 
        byte[] bFile = new byte[(int) file.length()];
 
        try {
            //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();
 
	    for (int i = 0; i < bFile.length; i++) {
	       	System.out.print((char)bFile[i]);
            }
 
	    System.out.println("Done");
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
}
