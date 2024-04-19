package com.minima.rosetta;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlockingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		      									throws ServletException, IOException {
		
		//Log requests..
		System.out.println("GET Request : "+request.getRequestURI());
		
		/*if ("POST".equalsIgnoreCase(request.getMethod())) 
		{
		   test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		}*/
		
		//Always reply in JSON
        response.setContentType("application/json");
        
        response.setStatus(HttpServletResponse.SC_OK);
        
        response.getWriter().println("{ \"status\": \"ok\"}");
    }
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
				throws ServletException, IOException {

		//Log requests..
		System.out.println("POST REQUEST : "+request.getRequestURI());
		
		BufferedReader br = request.getReader();
		
		String line = br.readLine();
		while(line != null) {
			System.out.println("POST DATA : "+line);
			line = br.readLine();
		}
		
		//Always reply in JSON
		response.setContentType("application/json");
		
		response.setStatus(HttpServletResponse.SC_OK);
		
		response.getWriter().println("{ \"status\": \"ok\"}");
	}
	
	protected void getResponse() {
		
	}
}
