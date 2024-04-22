package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

/**
 * In blockchains with sharded state, the SubNetworkIdentifier is required to 
 * query some object on a specific shard. This identifier is optional for 
 * all non-sharded blockchains.
 * @author spartacusrex
 *
 */
public class SubAccountIdentifier {
	
	//Required
	protected String 		address;
	
	//Optional
	protected JSONObject 	metadata = new JSONObject();
	
	public SubAccountIdentifier(String zAddress) {
		address = zAddress;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("address", address);
		ret.put("metadata", metadata);
		
		return ret;
	}
	
}
