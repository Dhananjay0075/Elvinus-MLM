package com.elvinus.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;



public class PasswordGenerator{

    static Cipher ecipher;
    static Cipher dcipher;
    // 8-byte Salt
    static byte[] salt = {
        (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
        (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };
    // Iteration count
    static int iterationCount = 19;
   
    
    public PasswordGenerator() { 

    }
    
    public static String encrypt(String plainText) 
            throws NoSuchAlgorithmException, 
            InvalidKeySpecException, 
            NoSuchPaddingException, 
            InvalidKeyException,
            InvalidAlgorithmParameterException, 
            UnsupportedEncodingException, 
            IllegalBlockSizeException, 
            BadPaddingException{
    	
    	String secretKey="elvinus127chain7"; 
    	
        //Key generation for enc and desc
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);        
         // Prepare the parameter to the ciphers
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

        //Enc process
        
        ecipher = Cipher.getInstance(key.getAlgorithm());
        ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);       
        String charSet="UTF-8";       
        byte[] in = plainText.getBytes(charSet);
        byte[] out =  ecipher.doFinal(in); 
        String encStr=new sun.misc.BASE64Encoder().encode(out);
        return encStr;
        
    }
    
    public static String  decrypt (String encryptedText)
    
    		throws NoSuchAlgorithmException, 
            InvalidKeySpecException, 
            NoSuchPaddingException, 
            InvalidKeyException,
            InvalidAlgorithmParameterException, 
            UnsupportedEncodingException, 
            IllegalBlockSizeException, 
            BadPaddingException, 
            IOException{
    	
    	String secretKey="elvinus127chain7"; 
    	
         //Key generation for enc and desc
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);        
         // Prepare the parameter to the ciphers
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
        //Decryption process; same key will be used for decr
        dcipher=Cipher.getInstance(key.getAlgorithm());
        dcipher.init(Cipher.DECRYPT_MODE, key,paramSpec); 
        byte[] enc = new sun.misc.BASE64Decoder().decodeBuffer(encryptedText);
        byte[] utf8 =  dcipher.doFinal(enc); 
        String charSet="UTF-8";     
        String plainStr = new String(utf8, charSet);
        return plainStr;
        
    }    
    
    
   public static void main(String arg[]) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException
   {
	   PasswordGenerator ob = new PasswordGenerator();
	  
	   System.out.println("Encrypted password = "+encrypt("admin"));
	   
	  // System.out.println("Decrypted password = "+decrypt("tTXeEnE/uvc="));
	   
   }
   
   
  
}



