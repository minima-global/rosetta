package com.minima.rosetta.objects.request;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.NetworkIdentifier;
import com.minima.rosetta.objects.models.Amount;
import com.minima.rosetta.objects.models.Operation;

public class ConstructionPreprocessRequest {

	NetworkIdentifier network_identifier;
	ArrayList<Operation> operations;
	
	JSONObject metadata = new JSONObject();
	
	ArrayList<Amount> max_fee;
	double suggested_fee_multiplier;
	
	public ConstructionPreprocessRequest(JSONObject zReq) {
		
		network_identifier = new NetworkIdentifier(zReq.getJSONObject("network_identifier"));
		
		operations = new ArrayList<>();
		JSONArray ops = zReq.getJSONArray("operations");
		int len = ops.length();
		for(int i=0;i<len;i++) {
			JSONObject opobj = ops.getJSONObject(i);
			Operation op = new Operation(opobj);
			operations.add(op);
		}
		
		if(zReq.has("metadata")) {
			metadata = zReq.getJSONObject("metadata");
		}
	}
}
