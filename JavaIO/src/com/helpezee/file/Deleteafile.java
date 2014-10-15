package com.helpezee.file;

import java.io.File;

public class Deleteafile {
	 public static void main(String[] args)
	    {	
	    	try{
	 
	    		File file = new File("./testing.txt");
	 
	    		if(file.delete()){
	    			System.out.println(file.getName() + " is deleted!");
	    		}else{
	    			System.out.println("Delete operation is failed.");
	    		}
	 
	    	}catch(Exception e){
	 
	    		e.printStackTrace();
	 
	    	}
	 
	    }
}
