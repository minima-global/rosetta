package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

public class OperationIdentifier {

	long index;
	long network_index = 0;
	
	public OperationIdentifier(long zIndex) {
		index = zIndex;
	}
	
	public OperationIdentifier(JSONObject zObj) {
		index = zObj.getLong("index");
		
		if(zObj.has("network_index")) {
			network_index = zObj.getLong("network_index");
		}
	}
	
	public JSONObject getObject(){
		JSONObject ret = new JSONObject();
		ret.put("index", index);
		ret.put("network_index", network_index);
		return ret;
	}
}
