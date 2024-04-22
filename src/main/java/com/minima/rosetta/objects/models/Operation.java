package com.minima.rosetta.objects.models;

import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.AccountIdentifier;
import com.minima.rosetta.objects.identifiers.OperationIdentifier;

public class Operation {
	
	protected OperationIdentifier operation_identifier;
		
	protected String type;
	
	protected String status;
	
	protected AccountIdentifier account;
	protected Amount amount;
	protected CoinChange coin_change;
	
	protected JSONObject metadata = new JSONObject();
	
	public Operation(	OperationIdentifier zOpIdentifier,
						String zType,
						String zStatus,
						AccountIdentifier zAccount,
						Amount zAmount,
						CoinChange zCoinChange) {
		
		operation_identifier 	= zOpIdentifier;
		type					= zType;
		status					= zStatus;
		account					= zAccount;
		amount					= zAmount;
		coin_change				= zCoinChange;		
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("operation_identifier", operation_identifier.getObject());
		ret.put("type", type);
		ret.put("status", status);
		ret.put("account", account.getObject());
		ret.put("amount", amount.getObject());
		ret.put("coin_change", coin_change.getObject());
		ret.put("metadata", metadata);
		
		return ret;
	}
}
