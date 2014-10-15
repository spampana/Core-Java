package com.helpezee.fileSerialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadanObjectfromfile {
	public static void main (String args[]) {
		 
		ReadanObjectfromfile deserializer = new ReadanObjectfromfile();
		   Address address = deserializer.deserialzeAddress();
		   System.out.println(address);
	   }
	 
	   public Address deserialzeAddress(){
	 
		   Address address;
	 
		   try{
	 
			   FileInputStream fin = new FileInputStream("./address.ser");
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   address = (Address) ois.readObject();
			   ois.close();
	 
			   return address;
	 
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   } 
	   } 
}
