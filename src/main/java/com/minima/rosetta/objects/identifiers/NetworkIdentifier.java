package com.minima.rosetta.objects.identifiers;

import org.json.JSONObject;

/**
 * The network_identifier specifies which network 
 * a particular object is associated with.
 * @author spartacusrex
 *
 */
public class NetworkIdentifier {

	//Required	
	String blockchain;
	String network;
	
	//Optional
	SubNetworkIdentifier sub_network_idebtifier;
	
	public NetworkIdentifier(String zBlockchain, String zNetwork){
		blockchain 	= zBlockchain;
		network		= zNetwork;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("blockchain", blockchain);
		ret.put("network", network);
		
		return ret;
	}
}
