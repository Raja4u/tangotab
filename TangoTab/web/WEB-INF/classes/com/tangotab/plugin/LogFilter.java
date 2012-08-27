package com.tangotab.plugin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogFilter implements Filter {
	

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String after=request.getRequestURI().replaceAll(request.getContextPath(),"");
        request.setAttribute("errorPath",after);
		/* send all web pages contains jsp and inner landing pages with /--/---.jsp  with out filtering */
		if( request.getRequestURI().indexOf(".")!=-1 || request.getRequestURI().indexOf("/jsp")!=-1 ){
			chain.doFilter(req, response);
		}
		else 
		{
			/* Test the string is lower case or not.. */
			if(! after.equals(after.toLowerCase()))
				response.sendRedirect(request.getContextPath()+after.toLowerCase());
			
			else 
				 chain.doFilter(request, response);
			
		}
		  
	}			
	public void init(FilterConfig config) throws ServletException {

		//Get init parameter
		String testParam = config.getInitParameter("test-param");

		//Print the init parameter
		System.out.println("Test Param: " + testParam);
	}
	public void destroy() {
		//add code to release any resource
	}
}