package com.minima.rosetta.endpoints;

import java.util.ArrayList;

import org.json.JSONObject;

import com.minima.rosetta.jetty.BlockingServlet;
import com.minima.rosetta.objects.identifiers.BlockIdentifier;
import com.minima.rosetta.objects.models.Amount;
import com.minima.rosetta.objects.predefined.MinimaAmount;
import com.minima.rosetta.objects.request.AccountBalanceRequest;
import com.minima.rosetta.objects.request.ConstructionPreprocessRequest;
import com.minima.rosetta.objects.response.AccountBalanceResponse;
import com.minima.rosetta.objects.response.ConstructionPreprocessResponse;
import com.minima.rosetta.testchain.testminima;

public class constructionPreprocess extends BlockingServlet {
	
	@Override
	protected JSONObject getResponse(JSONObject zParams) {
		
		ConstructionPreprocessRequest cppr = new ConstructionPreprocessRequest(zParams);
		
		JSONObject meta = new JSONObject();
		meta.put("paddy", "yes");
		
		ConstructionPreprocessResponse cppresp = new ConstructionPreprocessResponse(meta, new ArrayList<>());
		
		return cppresp.getObject();
	}
	
}
