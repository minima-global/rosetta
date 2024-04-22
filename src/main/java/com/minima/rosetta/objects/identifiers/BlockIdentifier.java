package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

public class BlockIdentifier {

	long index;
	String hash;
	
	public BlockIdentifier(long zIndex, String zHash) {
		index = zIndex;
		hash = zHash;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("index", index);
		ret.put("hash", hash);
		
		return ret;
	}
	
}
