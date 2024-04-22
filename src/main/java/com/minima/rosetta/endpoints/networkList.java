package com.minima.rosetta.endpoints;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minima.rosetta.jetty.BlockingServlet;

public class networkList extends BlockingServlet {

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
		
		response.getWriter().println("{"
				+ "  \"network_identifiers\": ["
				+ "    {"
				+ "      \"blockchain\": \"Minima\","
				+ "      \"network\": \"mainnet\""
				+ "    }"
				+ "  ]"
				+ "}");
	}
	
}
