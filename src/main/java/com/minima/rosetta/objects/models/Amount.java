package com.minima.rosetta.objects.models;

import org.json.JSONObject;

public class Amount {

	protected String value;
	protected Currency currency;
	protected JSONObject metadata;
	
	public Amount(String zValue, Currency zCurrency) {
		value 		= zValue;
		currency 	= zCurrency;
		//metadata	= new JSONObject();
	}
	
	public Amount(JSONObject zObj) {
		value 		= zObj.getString("value");
		currency 	= new Currency(zObj.getJSONObject("currency"));
		//metadata	= new JSONObject();
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("value", value);
		ret.put("currency", currency.getObject());
		//ret.put("metadata", metadata);
		
		return ret;
	}
}
