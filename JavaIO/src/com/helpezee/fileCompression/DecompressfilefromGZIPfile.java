package com.helpezee.fileCompression;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class DecompressfilefromGZIPfile {
	private static final String INPUT_GZIP_FILE = "/home/mkyong/file1.gz";
    private static final String OUTPUT_FILE = "/home/mkyong/file1.txt";
 
    public static void main( String[] args )
    {
    	DecompressfilefromGZIPfile gZip = new DecompressfilefromGZIPfile();
    	gZip.gunzipIt();
    }
 
    /**
     * GunZip it
     */
    public void gunzipIt(){
 
     byte[] buffer = new byte[1024];
 
     try{
 
    	 GZIPInputStream gzis = 
    		new GZIPInputStream(new FileInputStream(INPUT_GZIP_FILE));
 
    	 FileOutputStream out = 
            new FileOutputStream(OUTPUT_FILE);
 
        int len;
        while ((len = gzis.read(buffer)) > 0) {
        	out.write(buffer, 0, len);
        }
 
        gzis.close();
    	out.close();
 
    	System.out.println("Done");
 
    }catch(IOException ex){
       ex.printStackTrace();   
    }
   } 
}
