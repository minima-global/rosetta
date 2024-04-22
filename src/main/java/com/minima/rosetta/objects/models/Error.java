package com.minima.rosetta.objects.models;

import org.json.JSONObject;

public class Error {

	int code;
	String message;
	boolean retriable;
	JSONObject details;
	
	public Error(int zCode, String zMessage, boolean zRetry) {
		code 		= zCode;
		message 	= zMessage;
		retriable 	= zRetry;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("code", code);
		ret.put("message", message);
		ret.put("retriable", retriable);
		ret.put("details", details);
		
		return ret;
	}
}
