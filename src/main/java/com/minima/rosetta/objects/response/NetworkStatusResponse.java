package com.minima.rosetta.objects.response;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.BlockIdentifier;
import com.minima.rosetta.objects.identifiers.NetworkIdentifier;
import com.minima.rosetta.objects.models.Peer;

public class NetworkStatusResponse {

	BlockIdentifier current_block_identifier;
	long current_block_timestamp;
	
	BlockIdentifier genesis_block_identifier;
	BlockIdentifier oldest_block_identifier;
	
	ArrayList<Peer> peers;
	
	public NetworkStatusResponse(	BlockIdentifier zCurrent,
									long zCurrentTimeStamp,
									BlockIdentifier zGenesis,
									BlockIdentifier zOldest,
									ArrayList<Peer> zPeers
									) {
		current_block_identifier 	= zCurrent;
		current_block_timestamp		= zCurrentTimeStamp;
		genesis_block_identifier	= zGenesis;
		oldest_block_identifier		= zOldest;
		peers						= zPeers;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("current_block_identifier", current_block_identifier.getObject());
		ret.put("current_block_timestamp", current_block_timestamp);
		
		ret.put("genesis_block_identifier", genesis_block_identifier.getObject());
		ret.put("oldest_block_identifier", oldest_block_identifier.getObject());
		
		JSONArray arr = new JSONArray();
		for(Peer pr : peers) {
			arr.put(pr.getObject());
		}
		ret.put("peers", arr);
		
		return ret;
	}
}
