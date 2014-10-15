package com.helpezee.file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 The readLine() from the type DataInputStream is deprecated. 
 Sun officially announced this method can not convert property from bytes to characters. 
 It’s advised to use BufferedReader
 */
public class ReadfilewithBufferedInputStream {
	public static void main(String[] args) {
		 
		File file = new File("./newFile.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
 
		try {
			fis = new FileInputStream(file);
 
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
 
			while (dis.available() != 0) {
				System.out.println(dis.readLine());
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				bis.close();
				dis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
