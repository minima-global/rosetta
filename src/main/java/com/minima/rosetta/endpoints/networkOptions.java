package com.minima.rosetta.endpoints;

import org.json.JSONObject;

import com.minima.rosetta.jetty.BlockingServlet;
import com.minima.rosetta.objects.response.NetworkListResponse;
import com.minima.rosetta.objects.response.NetworkOptionsResponse;

public class networkOptions extends BlockingServlet {
	
	@Override
	protected JSONObject getResponse(JSONObject zParams) {
		
		//Create a NetworkListResponse
		NetworkOptionsResponse nor = new NetworkOptionsResponse();
		
		return nor.getObject();
	}
	
}
