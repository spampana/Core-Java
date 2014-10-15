package com.helpezee.fileCompression;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

import com.helpezee.fileSerialization.Address;

public class Compressserializedobjectintofile {
	public static void main (String args[]) {
		 
		Compressserializedobjectintofile serializer = new Compressserializedobjectintofile();
		   serializer.serializeAddress("wall street", "united state");
	   }
	 
	   public void serializeAddress(String street, String country){
	 
		   Address address = new Address();
		   address.setStreet(street);
		   address.setCountry(country);
	 
		   try{
	 
			   FileOutputStream fos = new FileOutputStream("c:\\address.gz");
			   GZIPOutputStream gz = new GZIPOutputStream(fos);
	 
			   ObjectOutputStream oos = new ObjectOutputStream(gz);
	 
			   oos.writeObject(address);
			   oos.close();
	 
			   System.out.println("Done");
	 
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }	 
	   }
}
