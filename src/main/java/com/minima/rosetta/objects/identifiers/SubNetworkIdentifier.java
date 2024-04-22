package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

/**
 * In blockchains with sharded state, the SubNetworkIdentifier is required to 
 * query some object on a specific shard. This identifier is optional for 
 * all non-sharded blockchains.
 * @author spartacusrex
 *
 */
public class SubNetworkIdentifier {
	
	//Required
	String 		network;
	
	//Optional
	JSONObject 	meta;
	
	public SubNetworkIdentifier(String zNetwork) {
		network = zNetwork;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("network", network);
		
		return ret;
	}
	
}
