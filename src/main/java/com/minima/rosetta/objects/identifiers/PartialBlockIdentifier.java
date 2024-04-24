package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

public class PartialBlockIdentifier {

	boolean mIsIndexDefined = false;
	protected long index = -1;
	
	boolean mIsHashDefined;
	protected String hash = "";
	
	public PartialBlockIdentifier(JSONObject zObject) {
		if(zObject.has("index")) {
			mIsIndexDefined = true;
			index 			= zObject.getLong("index");
		}
		
		if(zObject.has("hash")) {
			mIsHashDefined 	= true;
			hash 			= zObject.getString("hash");
		}
	}
	
	public boolean isAnyDefined() {
		return isIndexDefined() || isHashDefined();
	}
	
	public boolean isIndexDefined() {
		return mIsIndexDefined;
	}
	
	public long getIndex() {
		return index;
	}
	
	public boolean isHashDefined() {
		return mIsHashDefined;
	}
	
	public String getHash() {
		return hash;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		if(mIsIndexDefined) {
			ret.put("index", index);
		}
		
		if(mIsHashDefined) {
			ret.put("hash", hash);
		}
		
		return ret;
	}
	
}
