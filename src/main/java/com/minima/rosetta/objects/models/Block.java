package com.minima.rosetta.objects.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.BlockIdentifier;
import com.minima.rosetta.objects.identifiers.TransactionIdentifier;

public class Block {

	BlockIdentifier block_identifier;
	BlockIdentifier parent_block_identifier;
	
	long timestamp;
	
	ArrayList<Transaction> transactions;
	
	public Block(	BlockIdentifier zBlockIdent,
					BlockIdentifier zParentBlockIdent,
					long zTimeStamp,
					ArrayList<Transaction> zTransactions) {
		
		block_identifier 		= zBlockIdent;
		parent_block_identifier	= zParentBlockIdent;
		timestamp				= zTimeStamp;
		transactions			= zTransactions;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("block_identifier", block_identifier.getObject());
		ret.put("parent_block_identifier", parent_block_identifier.getObject());
		ret.put("timestamp", timestamp);
		
		JSONArray arr = new JSONArray();
		for(Transaction trans : transactions) {
			arr.put(trans.getObject());
		}
		
		ret.put("transactions", arr);
		
		return ret;
	}
}
