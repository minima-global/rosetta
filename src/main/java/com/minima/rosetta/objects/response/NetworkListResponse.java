package com.minima.rosetta.objects.response;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.NetworkIdentifier;

public class NetworkListResponse {

	ArrayList<NetworkIdentifier> network_identifiers;
	
	public NetworkListResponse() {
		
		NetworkIdentifier main = new NetworkIdentifier("Minima", "mainnet");
		
		network_identifiers = new ArrayList<>();
		network_identifiers.add(main);
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		JSONArray arr = new JSONArray();
		for(NetworkIdentifier netident : network_identifiers) {
			arr.put(netident.getObject());
		}
		
		ret.put("network_identifiers", arr);
		
		return ret;
	}
}
