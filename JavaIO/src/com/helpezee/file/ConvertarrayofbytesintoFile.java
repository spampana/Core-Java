package com.helpezee.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertarrayofbytesintoFile {
	public static void main( String[] args ) throws IOException
    {
    	FileInputStream fileInputStream=null;
 
        File file = new File("C:\\testing.txt");
        file.createNewFile();
 
        byte[] bFile = new byte[(int) file.length()];
 
        try {
        //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();
 
	    //convert array of bytes into file
	    FileOutputStream fileOuputStream = new FileOutputStream("C:\\testing2.txt"); 
	    fileOuputStream.write(bFile);
	    fileOuputStream.close();
 
	    System.out.println("Done");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
