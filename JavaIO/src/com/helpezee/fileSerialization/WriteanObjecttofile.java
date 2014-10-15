package com.helpezee.fileSerialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteanObjecttofile {
	
	public static void main (String args[]) {
		 
		WriteanObjecttofile serializer = new WriteanObjecttofile();
		   serializer.serializeAddress("wall street", "united state");
	   }
	 
	   public void serializeAddress(String street, String country){
	 
		   Address address = new Address();
		   address.setStreet(street);
		   address.setCountry(country);
	 
		   try{
	 
			FileOutputStream fout = new FileOutputStream("./address.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(address);
			oos.close();
			System.out.println("Done");
	 
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	   }
}
