package com.minima.rosetta.objects.response;

import org.json.JSONObject;

import com.minima.rosetta.objects.models.Transaction;

public class BlockTransactionResponse {

	Transaction transaction;
	
	public BlockTransactionResponse(Transaction zTrans) {
		transaction = zTrans;
	}
	
	public JSONObject getObject() {
		JSONObject ret = new JSONObject();
		
		ret.put("transaction", transaction.getObject());
		
		return ret;
	}
	
}
