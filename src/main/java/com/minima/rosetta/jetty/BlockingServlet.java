package com.minima.rosetta.jetty;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.minima.rosetta.Log;

public abstract class BlockingServlet extends HttpServlet {
	
	private static Random mRand = new Random();
	
	/*protected void doGet(HttpServletRequest request,HttpServletResponse response)
		      									throws ServletException, IOException {
		
		//Log requests..
		System.out.println("GET Request : "+request.getRequestURI());
		
		//Always reply in JSON
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("{ \"status\": \"ok\"}");
    }*/
	
	protected void doPost(	HttpServletRequest request,
							HttpServletResponse response)
				throws ServletException, IOException {
		
		//Get the POST params
		BufferedReader br = request.getReader();
		
		String tot = "";
		String line = br.readLine();
		while(line != null) {
		//	System.out.println("POST DATA : "+line);
			tot = tot+line;
			line = br.readLine();
		}
		
		//Now make a JSON
		JSONObject json = new JSONObject(tot);

		String randid = Long.toHexString(mRand.nextLong());
		
		//Log requests..
		if(Log.LOGGING_ENABLED) {
			Log.log("POST RECEIVE "+randid+" : "+request.getRequestURI()+" "+json.toString());
		}
		
		//Now run it..
		JSONObject res = getResponse(json);
		
		String resp = res.toString();
		if(Log.LOGGING_ENABLED) {
			Log.log("POST REPLY "+randid+" : "+resp);
		}
		
		//Always reply in JSON
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println(resp);
	}
	
	protected abstract JSONObject getResponse(JSONObject zParams);
}
