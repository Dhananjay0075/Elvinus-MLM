package com.elvinus.util;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class GetClassPath {

    public String getPath() throws UnsupportedEncodingException {
 		
 		//String path = this.getClass().getClassLoader().getResource("").getPath();
 		
 		String path = this.getClass().getClassLoader().getResource("").getPath();
 		
 		InputStream in = this.getClass().getResourceAsStream("/emailTemp.txt");
 		
 		String filePath = "";
 		String fullPath = URLDecoder.decode(path, "UTF-8");
 		String pathArr[] = fullPath.split("/WEB-INF/classes/");
 		
 		filePath = fullPath;
 		
 		System.out.println(fullPath);
 		System.out.println(pathArr[0]);
 		
 		fullPath = pathArr[0];
 		
 		String reponsePath = "";
 		
 		// to read a file from webcontent
 		//reponsePath = new File(fullPath).getPath() + File.separatorChar + "emailTemp.txt";
 		
 		reponsePath = new File(filePath).getPath() + File.separatorChar + "emailTemp.txt";
 		
 		return reponsePath;
 	
 	}
    
    public static void main(String args[]) 
    { 
    	GetClassPath obj = new GetClassPath();
    	
    	try {
			String fileName = obj.getPath();
			System.out.println("File Source=="+fileName);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
