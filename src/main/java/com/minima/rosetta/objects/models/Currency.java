package com.minima.rosetta.objects.models;

import org.json.JSONObject;

public class Currency {

	protected String 		symbol;
	protected int 			decimals;
	protected JSONObject 	metadata = null;
	
	public Currency(String zSymbol, int zDecimals, JSONObject zMeta) {
		symbol 		= zSymbol;
		decimals 	= zDecimals;
		metadata 	= zMeta;
	}
	
	public Currency(JSONObject zObj) {
		symbol 		= zObj.getString("symbol");
		decimals 	= zObj.getInt("decimals");
		
		if(zObj.has("metadata")) {
			metadata 	= zObj.getJSONObject("metadata");
		}
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("symbol", symbol);
		ret.put("decimals", decimals);
		
		if(metadata != null) {
			ret.put("metadata", metadata);
		}
		
		return ret;
	}
}
