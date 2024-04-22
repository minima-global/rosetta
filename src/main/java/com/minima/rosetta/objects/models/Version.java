package com.minima.rosetta.objects.models;

import org.json.JSONObject;

public class Version {

	String rosetta_version;
	String node_version;
	String middleware_version;
	JSONObject metadata = new JSONObject();
	
	public Version(String zRosettaVersion, String zNodeVersion, String zMiddle) {
		rosetta_version 	= zRosettaVersion;
		node_version		= zNodeVersion;
		middleware_version	= zMiddle;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("rosetta_version", rosetta_version);
		ret.put("node_version", node_version);
		ret.put("middleware_version", middleware_version);
		ret.put("metadata", metadata);
		
		return ret;
	}
}
