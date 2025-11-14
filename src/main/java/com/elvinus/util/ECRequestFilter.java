package com.elvinus.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
 

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class ECRequestFilter implements Filter {
 
    private ArrayList<String> urlList;
     
    public void destroy() {
    }
 
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        
    	HttpServletResponse hsr = (HttpServletResponse) res;
        hsr.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        hsr.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        hsr.setDateHeader("Expires", 0); // Proxies.
        
        chain.doFilter(req, res);
    }
 
    public void init(FilterConfig config) throws ServletException {
        
    	
    }
    
   
}
