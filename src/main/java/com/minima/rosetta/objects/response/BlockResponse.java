package com.minima.rosetta.objects.response;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.TransactionIdentifier;
import com.minima.rosetta.objects.models.Block;

public class BlockResponse {

	Block block;
	ArrayList<TransactionIdentifier> other_transactions;
	
	public BlockResponse(Block zBlock, ArrayList<TransactionIdentifier> zTransactions) {
		block = zBlock;
		other_transactions = zTransactions;
	}
	
	public JSONObject getObject() {
		
		JSONObject ret = new JSONObject();
		
		ret.put("block", block.getObject());
		
		JSONArray arr = new JSONArray();
		for(TransactionIdentifier txnid : other_transactions) {
			arr.put(txnid.getObject());
		}
		ret.put("other_trransactions", arr);
		
		return ret;
	}
}
