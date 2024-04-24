package com.minima.rosetta.objects.response;

import org.json.JSONObject;

import com.minima.rosetta.objects.models.Allow;
import com.minima.rosetta.objects.models.Version;

public class NetworkOptionsResponse {

	Version version;
	Allow allow;
	
	public NetworkOptionsResponse() {
		version = new Version("v0.10.3", "1.0.40", "0.1");
		allow	= new Allow();
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("version", version.getObject());
		ret.put("allow", allow.getObject());
		
		return ret;
	}
}
