package com.elvinus.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.elvinus.bean.ECommBilling;
import com.elvinus.bean.ECommShipping;
import com.elvinus.bean.ECommUserReg;
import com.elvinus.model.UserOrder;

import junit.framework.Assert;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.message.BasicNameValuePair;

public class HitEcommClient {

	public static final String REST_SERVICE_URI = "https://www.elvinus.com/wp-json/wc/v3/customers";
		  
    /*
     * Add HTTP Authorization header, using Basic-Authentication to send user-credentials.
     */
	
    private static HttpHeaders getHeaders(){
        String plainCredentials="ck_11498aa25748706343dcdd31f1610e3a136ec540:cs_f472ab8928b89966ed0b85835d15ef0caec11912";
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
         
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        
        return headers;
    }
	     
	
    public static void createUser(ECommUserReg ecomReg) {
    	
        System.out.println("\nTesting create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        
        HttpEntity<Object> request = new HttpEntity<Object>(ecomReg, getHeaders());
        //URI uri = restTemplate.postForLocation(REST_SERVICE_URI, request, ECommUserReg.class);
        
        ResponseEntity<ECommUserReg> response = restTemplate.postForEntity( REST_SERVICE_URI, request , ECommUserReg.class );
		
		//JSONObject resObject = new JSONObject(response.getBody());
		
		System.out.println("Data="+response.getBody());	
		
        //System.out.println("Location : "+uri.toASCIIString());
    }
    
    
    public static UserOrder getOrderDetails(int orderId) {
    	
    	UserOrder userOrder = new UserOrder();
    	
    	final String baseUrl = "https://www.elvinus.com/wp-json/wc/v3/orders/"+orderId;
         
    	RestTemplate restTemplate = new RestTemplate();
        final String url = baseUrl;
        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
       
        ResponseEntity<String> userResponse = restTemplate.exchange(url,HttpMethod.GET,request, String.class);
        
        JSONObject resObject = new JSONObject(userResponse.getBody());
        
        userOrder.setOrder_date(new Date());
        userOrder.setElvinus_order_id(orderId);
        userOrder.setOrder_amount(Double.parseDouble(resObject.getString("total")));
        userOrder.setPayment_mode(resObject.getString("payment_method"));
        
    	return userOrder;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	public static void main(String str[]) throws ClientProtocolException, IOException
	{	
		/*ECommUserReg ecomReg = new ECommUserReg("abinash.raula12@jirehsol.com","Abinash","Raula","ABI12721","asd123",new ECommBilling("","","","","","","","","","",""),new ECommShipping("","","","","","","","",""));
    	
		createUser(ecomReg);*/
		
		getOrderDetails(1725);
	}
}
