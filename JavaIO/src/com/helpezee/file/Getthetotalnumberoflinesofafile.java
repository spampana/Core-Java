package com.helpezee.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
/*
 The LineNumberReader class is a useful class to handle the lines of a file, 
 you can loop the LineNumberReader.readLine() method and accumulate it as the 
 total number of lines. A line is considered a line if it ends with a line feed
  (‘\n’) or a carriage return (‘\r’).
 */
public class Getthetotalnumberoflinesofafile {
	public static void main(String[] args)
    {	
 
    	try{
 
    		File file =new File("./newFile.txt");
 
    		if(file.exists()){
 
    		    FileReader fr = new FileReader(file);
    		    LineNumberReader lnr = new LineNumberReader(fr);
 
    		    int linenumber = 0;
 
    	            while (lnr.readLine() != null){
    	        	linenumber++;
    	            }
 
    	            System.out.println("Total number of lines : " + linenumber);
 
    	            lnr.close();
 
 
    		}else{
    			 System.out.println("File does not exists!");
    		}
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
 
    }
}
