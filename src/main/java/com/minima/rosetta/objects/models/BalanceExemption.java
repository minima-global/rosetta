package com.minima.rosetta.objects.models;

import org.json.JSONObject;

public class BalanceExemption {

	enum ExemptionType {
		greater_or_equal,
		less_or_equal,
		dynamic
	}
	
	String sub_account_address;
	Currency currency;
	ExemptionType exemption_type;
	
	public BalanceExemption(String zSubAccount, Currency zCurrency, ExemptionType zExemptionType) {
		sub_account_address = zSubAccount;
		currency			= zCurrency;
		exemption_type		= zExemptionType;
	}
	
	public JSONObject getObject(){
		
		JSONObject ret = new JSONObject();
		
		ret.put("sub_account_address", sub_account_address);
		ret.put("currency", currency.getObject());
		ret.put("exemption_type", exemption_type.toString());
		
		return ret;
	}
}
