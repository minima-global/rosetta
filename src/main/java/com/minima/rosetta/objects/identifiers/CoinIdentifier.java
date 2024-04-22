package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

public class CoinIdentifier {

	String identifier;
	
	public CoinIdentifier(String zIdentifier) {
		identifier = zIdentifier;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("identifier", identifier);
		
		return ret;
	}
}
