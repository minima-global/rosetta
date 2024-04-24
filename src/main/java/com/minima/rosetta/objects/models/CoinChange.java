package com.minima.rosetta.objects.models;

import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.CoinIdentifier;

public class CoinChange {
	
	public enum CoinAction {
		coin_created,
		coin_spent
	}
	
	CoinIdentifier coin_identifier;
	
	CoinAction coin_action;
	
	public CoinChange(CoinIdentifier zCoinIdentifier, CoinAction zCoinAction) {
		coin_identifier = zCoinIdentifier;
		coin_action		= zCoinAction;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("coin_identifier", coin_identifier.getObject());
		ret.put("coin_action", coin_action.toString());
		
		return ret;
	}
}
