package com.minima.rosetta.endpoints;

import java.util.ArrayList;

import org.json.JSONObject;

import com.minima.rosetta.jetty.BlockingServlet;
import com.minima.rosetta.objects.identifiers.BlockIdentifier;
import com.minima.rosetta.objects.models.Amount;
import com.minima.rosetta.objects.predefined.MinimaAmount;
import com.minima.rosetta.objects.request.AccountBalanceRequest;
import com.minima.rosetta.objects.response.AccountBalanceResponse;
import com.minima.rosetta.objects.response.NetworkListResponse;
import com.minima.rosetta.testchain.testminima;

public class accountBalance extends BlockingServlet {
	
	@Override
	protected JSONObject getResponse(JSONObject zParams) {
		
		AccountBalanceRequest abr = new AccountBalanceRequest(zParams);
		
		//get the balance
		String address = abr.getAccountIdentifier().getAddress();
		
		ArrayList<Amount> balances = new ArrayList<>();
		
		if(address.equals("0xFF")) {
			balances.add(new MinimaAmount("200000"));
		}else {
			balances.add(new MinimaAmount("100000"));
		}
		
		BlockIdentifier topblockid = testminima.getTestMinima().getTopBlock().getBlockIdentifier();
		
		AccountBalanceResponse acresp = new AccountBalanceResponse(topblockid, balances);
		
		return netresp.getObject();
	}
	
}