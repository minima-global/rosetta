package com.minima.rosetta.endpoints;

import org.json.JSONObject;

import com.minima.rosetta.jetty.BlockingServlet;

public class block extends BlockingServlet {

	@Override
	protected JSONObject getResponse(JSONObject zParams) {
		return new JSONObject();
	}

}
