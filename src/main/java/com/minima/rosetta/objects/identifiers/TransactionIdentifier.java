package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

public class TransactionIdentifier {

	String hash;
	
	public TransactionIdentifier(String zHash) {
		hash = zHash;
	}
	
	public TransactionIdentifier(JSONObject zObj) {
		hash = zObj.getString("hash");
	}
	
	public String getHash() {
		return hash;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("hash", hash);
		
		return ret;
	}
}
