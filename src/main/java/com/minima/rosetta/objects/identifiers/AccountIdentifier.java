package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

/**
 * In blockchains with sharded state, the SubNetworkIdentifier is required to 
 * query some object on a specific shard. This identifier is optional for 
 * all non-sharded blockchains.
 * @author spartacusrex
 *
 */
public class AccountIdentifier {
	
	//Required
	String 		address;
	
	//Optional
	SubAccountIdentifier sub_account;
	JSONObject 	metadata;
	
	public AccountIdentifier(String zAddress) {
		address = zAddress;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("address", address);
		
		return ret;
	}
	
}
