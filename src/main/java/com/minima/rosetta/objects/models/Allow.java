package com.minima.rosetta.objects.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.minima.rosetta.objects.predefined.ErrorNoConnect;
import com.minima.rosetta.objects.predefined.SuccessOperationStatus;

public class Allow {

	ArrayList<OperationStatus> operation_statuses 	= new ArrayList<>();
	ArrayList<String> operation_types 				= new ArrayList<>();
	ArrayList<Error> errors 						= new ArrayList<>();
	
	boolean historical_balance_lookup = false;
	
	ArrayList<String> call_methods = new ArrayList<>();
	
	ArrayList<BalanceExemption> balance_exemptions = new ArrayList<>();
	
	boolean mempool_coins = false;
	
	//Create the default ALLOW object fro Minima Rosetta
	public Allow() {
		
		operation_statuses.add(new SuccessOperationStatus());
		
		operation_types.add("transfer");
		
		errors.add(new ErrorNoConnect());
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		JSONArray arr = new JSONArray();
		for(OperationStatus opstats : operation_statuses) {
			arr.put(opstats.getObject());
		}
		ret.put("operation_statuses", arr);
		
		arr = new JSONArray();
		for(String optypes : operation_types) {
			arr.put(optypes);
		}
		ret.put("operation_types", arr);
		
		arr = new JSONArray();
		for(Error err : errors) {
			arr.put(err.getObject());
		}
		ret.put("errors", arr);
		
		ret.put("historical_balance_lookup", false);
		
		arr = new JSONArray();
		for(String cmeth : call_methods) {
			arr.put(cmeth);
		}
		ret.put("call_methods", arr);
		
		arr = new JSONArray();
		for(BalanceExemption balex : balance_exemptions) {
			arr.put(balex.getObject());
		}
		ret.put("balance_exemptions", arr);
		
		ret.put("mempoll_coins", false);
		
		return ret;
	}
	
	
	
}
