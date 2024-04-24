package com.minima.rosetta.objects.request;

import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.AccountIdentifier;
import com.minima.rosetta.objects.identifiers.NetworkIdentifier;
import com.minima.rosetta.objects.identifiers.PartialBlockIdentifier;

public class AccountBalanceRequest {

	//Required
	NetworkIdentifier network_identifier;
	AccountIdentifier account_identifier;
	
	PartialBlockIdentifier block_identifier = null;
	
	public AccountBalanceRequest(JSONObject zReq) {
		network_identifier 	= new NetworkIdentifier(zReq.getJSONObject("network_identifier"));
		account_identifier	= new AccountIdentifier(zReq.getJSONObject("account_identifier"));
		
		if(zReq.has("block_identifier")) {
			block_identifier = new PartialBlockIdentifier(zReq.getJSONObject("block_identifier"));
		}
	}
	
	public AccountIdentifier getAccountIdentifier() {
		return account_identifier;
	}
}
