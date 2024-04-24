package com.minima.rosetta.objects.request;

import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.NetworkIdentifier;
import com.minima.rosetta.objects.identifiers.PartialBlockIdentifier;

public class BlockRequest {

	NetworkIdentifier network_identifier;
	PartialBlockIdentifier block_identifier;
	
	public BlockRequest(JSONObject zBlockReq) {
		network_identifier 	= new NetworkIdentifier(zBlockReq.getJSONObject("network_identifier"));
		block_identifier	= new PartialBlockIdentifier(zBlockReq.getJSONObject("block_identifier"));
	}
	
	public NetworkIdentifier getNetworkIdentifier() {
		return network_identifier;
	}
	
	public PartialBlockIdentifier getPartialBlockIdentifier() {
		return block_identifier;
	}
	
}
