package com.minima.rosetta.endpoints;

import org.json.JSONObject;

import com.minima.rosetta.jetty.BlockingServlet;
import com.minima.rosetta.objects.response.NetworkListResponse;

public class networkList extends BlockingServlet {
	
	@Override
	protected JSONObject getResponse(JSONObject zParams) {
		
		//Create a NetworkListResponse
		NetworkListResponse netresp  = new NetworkListResponse();
		
		return netresp.getObject();
	}
	
}
