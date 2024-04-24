package com.minima.rosetta.objects.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.TransactionIdentifier;

public class Transaction {

	TransactionIdentifier transaction_identifier;
	
	ArrayList<Operation> operations;
	
	public Transaction(TransactionIdentifier zTransactionIdent, ArrayList<Operation> zOperations) {
		transaction_identifier 	= zTransactionIdent;
		operations 				= zOperations;
	}
	
	public TransactionIdentifier getTransactionIdentifier() {
		return transaction_identifier;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("transaction_identifier", transaction_identifier.getObject());
		
		JSONArray arr = new JSONArray();
		for(Operation op : operations) {
			arr.put(op.getObject());
		}
		ret.put("operations", arr);
		
		return ret;
	}
}
