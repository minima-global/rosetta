package com.minima.rosetta.objects.models;

import org.json.JSONObject;

public class OperationStatus {

	String status;
	boolean successful;
	
	public OperationStatus(String zStatus, boolean zSuccess) {
		status 		= zStatus;
		successful 	= zSuccess;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("status", status);
		ret.put("successful", successful);
		
		return ret;
	}
}
