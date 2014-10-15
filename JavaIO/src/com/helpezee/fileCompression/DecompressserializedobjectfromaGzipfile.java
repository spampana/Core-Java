package com.helpezee.fileCompression;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.zip.GZIPInputStream;

import javax.xml.rpc.encoding.Deserializer;

import com.helpezee.fileSerialization.Address;

public class DecompressserializedobjectfromaGzipfile {
	public static void main (String args[]) {
		 
		DecompressserializedobjectfromaGzipfile deserializer = new DecompressserializedobjectfromaGzipfile();
		   Address address = deserializer.deserialzeAddress();
		   System.out.println(address);
	   }
	 
	   public Address deserialzeAddress(){
	 
		   Address address;
	 
		   try{
	 
			   FileInputStream fin = new FileInputStream("c:\\address.gz");
			   GZIPInputStream gis = new GZIPInputStream(fin);
			   ObjectInputStream ois = new ObjectInputStream(gis);
			   address = (Address) ois.readObject();
			   ois.close();
	 
			   return address;
	 
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   } 
	   } 
	   
}
