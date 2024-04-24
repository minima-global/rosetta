package com.minima.rosetta.endpoints;

import java.util.ArrayList;

import org.json.JSONObject;

import com.minima.rosetta.jetty.BlockingServlet;
import com.minima.rosetta.objects.identifiers.PartialBlockIdentifier;
import com.minima.rosetta.objects.identifiers.TransactionIdentifier;
import com.minima.rosetta.objects.models.Block;
import com.minima.rosetta.objects.models.Transaction;
import com.minima.rosetta.objects.request.BlockRequest;
import com.minima.rosetta.objects.request.BlockTransactionRequest;
import com.minima.rosetta.objects.response.BlockResponse;
import com.minima.rosetta.objects.response.BlockTransactionResponse;
import com.minima.rosetta.testchain.testblock;
import com.minima.rosetta.testchain.testminima;

public class blockTransaction extends BlockingServlet {
	
	@Override
	protected JSONObject getResponse(JSONObject zParams) {
		
		BlockTransactionRequest btr = new BlockTransactionRequest(zParams);
		
		TransactionIdentifier transid = btr.getTransactionIdentifier();
		
		//Get that transaction..
		Transaction trans = testminima.getTestMinima().getTransaction(transid.getHash());
		
		BlockTransactionResponse btresp = new BlockTransactionResponse(trans);
		
		return btresp.getObject();
	}
}
