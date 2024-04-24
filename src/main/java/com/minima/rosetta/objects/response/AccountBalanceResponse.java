package com.minima.rosetta.objects.response;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.BlockIdentifier;
import com.minima.rosetta.objects.identifiers.TransactionIdentifier;
import com.minima.rosetta.objects.models.Amount;
import com.minima.rosetta.objects.models.Block;

public class AccountBalanceResponse {

	BlockIdentifier block_identifier;
	ArrayList<Amount> balances;
	JSONObject metadata = new JSONObject();
	
	public AccountBalanceResponse(BlockIdentifier zBlkIdent, ArrayList<Amount> zAmounts) {
		block_identifier = zBlkIdent;
		balances = zAmounts;
	}
	
	public JSONObject getObject() {
		
		JSONObject ret = new JSONObject();
		
		ret.put("block_identifier", block_identifier.getObject());
		
		JSONArray arr = new JSONArray();
		for(Amount amt : balances) {
			arr.put(amt.getObject());
		}
		ret.put("balances", arr);
		
		ret.put("metadata", metadata);
		
		return ret;
	}
}
