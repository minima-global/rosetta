package com.minima.rosetta.endpoints;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minima.rosetta.BlockingServlet;

public class networkStatus extends BlockingServlet {

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
		
		response.getWriter().println("{\r\n"
				+ "  \"current_block_identifier\": {\r\n"
				+ "    \"index\": 1123941,\r\n"
				+ "    \"hash\": \"0x1f2cc6c5027d2f201a5453ad1119574d2aed23a392654742ac3c78783c071f85\"\r\n"
				+ "  },\r\n"
				+ "  \"current_block_timestamp\": 1582833600000,\r\n"
				+ "  \"genesis_block_identifier\": {\r\n"
				+ "    \"index\": 1123941,\r\n"
				+ "    \"hash\": \"0x1f2cc6c5027d2f201a5453ad1119574d2aed23a392654742ac3c78783c071f85\"\r\n"
				+ "  },\r\n"
				+ "  \"oldest_block_identifier\": {\r\n"
				+ "    \"index\": 1123941,\r\n"
				+ "    \"hash\": \"0x1f2cc6c5027d2f201a5453ad1119574d2aed23a392654742ac3c78783c071f85\"\r\n"
				+ "  },\r\n"
				+ "  \"sync_status\": {\r\n"
				+ "    \"current_index\": 100,\r\n"
				+ "    \"target_index\": 150,\r\n"
				+ "    \"stage\": \"header sync\",\r\n"
				+ "    \"synced\": \"boolean\"\r\n"
				+ "  },\r\n"
				+ "  \"peers\": [\r\n"
				+ "    {\r\n"
				+ "      \"peer_id\": \"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\",\r\n"
				+ "      \"metadata\": null\r\n"
				+ "    }\r\n"
				+ "  ]");
	}
	
}
