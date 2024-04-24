package com.minima.rosetta.objects.models;

import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.AccountIdentifier;
import com.minima.rosetta.objects.identifiers.OperationIdentifier;

public class Operation {
	
	public OperationIdentifier operation_identifier;
		
	public String type = "";
	
	public String status = "";
	
	public AccountIdentifier account;
	public Amount amount;
	
	boolean valid_coin_change = false;
	public CoinChange coin_change;
	
	public JSONObject metadata = new JSONObject();
	
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
		valid_coin_change 		= true;
		coin_change				= zCoinChange;		
	}
	
	public Operation(JSONObject zObj) {
		operation_identifier 	= new OperationIdentifier(zObj.getJSONObject("operation_identifier"));
		type 					= zObj.getString("type");
		account					= new AccountIdentifier(zObj.getJSONObject("account"));
		amount					= new Amount(zObj.getJSONObject("amount"));
		
		/*if(zObj.has("coin_change")) {
			coin_change = zObj.getString("coin_change");
		}*/
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
