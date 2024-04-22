package com.minima.rosetta.objects.models;

import org.json.JSONObject;

public class Currency {

	protected String 		symbol;
	protected int 			decimals;
	protected JSONObject 	metadata;
	
	public Currency(String zSymbol, int zDecimals) {
		symbol 		= zSymbol;
		decimals 	= zDecimals;
		metadata 	= new JSONObject();
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("symbol", symbol);
		ret.put("decimals", decimals);
		ret.put("metadata", metadata);
		
		return ret;
	}
}
