package com.minima.rosetta.objects.models;

import org.json.JSONObject;

public class Peer {

	String peer_id;
	
	public Peer(String zPeerid) {
		peer_id = zPeerid;
	}
	
	public JSONObject getObject(){
		JSONObject ret = new JSONObject();
		ret.put("peer_id", peer_id);
		return ret;
	}
}
