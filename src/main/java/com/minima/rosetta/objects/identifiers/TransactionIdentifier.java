package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

public class TransactionIdentifier {

	String hash;
	
	public TransactionIdentifier(String zHash) {
		hash = zHash;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("hash", hash);
		
		return ret;
	}
}
