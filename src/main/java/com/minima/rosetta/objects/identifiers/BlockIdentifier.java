package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

public class BlockIdentifier {

	protected long index;
	protected String hash;
	
	public BlockIdentifier(long zIndex, String zHash) {
		index = zIndex;
		hash = zHash;
	}
	
	public BlockIdentifier(JSONObject zObject) {
		index 	= zObject.getLong("index");
		hash 	= zObject.getString("hash");
	}
	
	public long getIndex() {
		return index;
	}
	
	public String getHash() {
		return hash;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("index", index);
		ret.put("hash", hash);
		
		return ret;
	}
}
