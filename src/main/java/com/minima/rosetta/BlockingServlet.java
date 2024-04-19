package com.minima.rosetta;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlockingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		      									throws ServletException, IOException {
		
		//Log requests..
		System.out.println("Request : "+request.getMethod()+" "+request.getRequestURI());
		
		//Always reply in JSON
        response.setContentType("application/json");
        
        response.setStatus(HttpServletResponse.SC_OK);
        
        response.getWriter().println("{ \"status\": \"ok\"}");
    }
	
	protected void getResponse() {
		
	}
}
