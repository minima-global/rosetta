package com.minima.rosetta.objects.response;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.minima.rosetta.objects.identifiers.AccountIdentifier;
import com.minima.rosetta.objects.models.Transaction;

public class ConstructionPreprocessResponse {

	JSONObject options;
	ArrayList<AccountIdentifier> required_public_keys;
	
	public ConstructionPreprocessResponse(JSONObject zOptions, ArrayList<AccountIdentifier> zAccs) {
		options = zOptions;
		required_public_keys = zAccs;
	}
	
	public JSONObject getObject() {
		JSONObject ret = new JSONObject();
		
		ret.put("options", options);
		
		JSONArray arr = new JSONArray();
		for(AccountIdentifier  acc : required_public_keys) {
			arr.put(acc.getObject());
		}
		ret.put("required_public_keys", arr);
		
		return ret;
	}
	
}
