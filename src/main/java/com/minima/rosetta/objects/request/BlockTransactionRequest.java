package com.minima.rosetta.objects.request;

import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.BlockIdentifier;
import com.minima.rosetta.objects.identifiers.NetworkIdentifier;
import com.minima.rosetta.objects.identifiers.TransactionIdentifier;

public class BlockTransactionRequest {

	NetworkIdentifier network_identifier;
	BlockIdentifier block_identifier;
	TransactionIdentifier transaction_identifier;
	
	public BlockTransactionRequest(JSONObject zReq) {
		network_identifier 		= new NetworkIdentifier(zReq.getJSONObject("network_identifier"));
		block_identifier		= new BlockIdentifier(zReq.getJSONObject("block_identifier"));
		transaction_identifier	= new TransactionIdentifier(zReq.getJSONObject("transaction_identifier"));
	}
	
	public TransactionIdentifier getTransactionIdentifier() {
		return transaction_identifier;
	}
}
