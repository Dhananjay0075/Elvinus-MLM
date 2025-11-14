package com.elvinus.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class ReadFileToString {

	
	private static final Logger LOGGER = Logger.getLogger(ReadFileToString.class);
	
	public static void main(String[] args) {
		
		URL fileUrl = new ReadFileToString().getClass().getResource("/emailTemp.txt");
        String fileName = fileUrl.getFile();
        String contents = "";
        
        //String fileName = "E:/STSWorkSpace/Elvinus-Chain-18-10-2018/ElvinusV01/src/main/webapp/WEB-INF/view/email_template.jsp";
		
		/*contents = readUsingScanner(fileName);
		System.out.println("*****Read File to String Using Scanner*****\n" + contents);

		contents = readUsingApacheCommonsIO(fileName);
		System.out.println("*****Read File to String Using Apache Commons IO FileUtils*****\n" + contents);

		contents = readUsingFiles(fileName);
		System.out.println("*****Read File to String Using Files Class*****\n" + contents);

		contents = readUsingBufferedReader(fileName);
		System.out.println("*****Read File to String Using BufferedReader*****\n" + contents);

		contents = readUsingBufferedReaderCharArray(fileName);
		System.out.println("*****Read File to String Using BufferedReader and char array*****\n" + contents);
*/
		contents = readUsingFileInputStream();
		
		contents = contents.replaceAll("FULLNAME", "ABINASH RAULA");
		System.out.println("*****Read File to String Using FileInputStream*****\n" + contents);

	}
	
	

	private static String readUsingBufferedReaderCharArray(String fileName) {
		
		BufferedReader reader = null;
		StringBuilder stringBuilder = new StringBuilder();
		char[] buffer = new char[10];
		try {
			reader = new BufferedReader(new FileReader(fileName));
			while (reader.read(buffer) != -1) {
				stringBuilder.append(new String(buffer));
				buffer = new char[10];
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return stringBuilder.toString();
	}
	
	public static String readUsingFileInputStream() {
		
		GetClassPath obj = new GetClassPath();
		
		//URL fileUrl = new ReadFileToString().getClass().getResource("/emailTemp.txt");
		
		//LOGGER.info("Email File Path="+fileUrl);
		
		String fileName = "";
				
		try {
			fileName = obj.getPath();
			LOGGER.info("File Path In Class="+fileName);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        //fileName = fileUrl.getFile();
        
        LOGGER.info("Email File Path In Sting="+fileName);
        
		FileInputStream fis = null;
		byte[] buffer = new byte[10];
		StringBuilder sb = new StringBuilder();
		
		try {
			fis = new FileInputStream(fileName);

			while (fis.read(buffer) != -1) {
				
				LOGGER.info("While reading="+new String(buffer));
				
				sb.append(new String(buffer));
				buffer = new byte[10];
			}
			fis.close();

		} catch (IOException e) {
			
			LOGGER.error("File read time="+e.getMessage());
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					
					LOGGER.error("File read time2="+e.getMessage());
					e.printStackTrace();
				}
		}
		
		LOGGER.info("File Data Size="+sb.length());
		
		return sb.toString();
	}

	private static String readUsingBufferedReader(String fileName) {
		BufferedReader reader = null;
		StringBuilder stringBuilder = new StringBuilder();

		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = null;
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			// delete the last ls
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return stringBuilder.toString();
	}

	private static String readUsingFiles(String fileName) {
		try {
			return new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String readUsingApacheCommonsIO(String fileName) {
		try {
			return FileUtils.readFileToString(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String readUsingScanner(String fileName) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
			// we can use Delimiter regex as "\\A", "\\Z" or "\\z"
			String data = scanner.useDelimiter("\\A").next();
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (scanner != null)
				scanner.close();
		}

	}

}
