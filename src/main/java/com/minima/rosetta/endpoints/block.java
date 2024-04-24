package com.minima.rosetta.endpoints;

import java.util.ArrayList;

import org.json.JSONObject;

import com.minima.rosetta.jetty.BlockingServlet;
import com.minima.rosetta.objects.identifiers.PartialBlockIdentifier;
import com.minima.rosetta.objects.models.Block;
import com.minima.rosetta.objects.request.BlockRequest;
import com.minima.rosetta.objects.response.BlockResponse;
import com.minima.rosetta.testchain.testblock;
import com.minima.rosetta.testchain.testminima;

public class block extends BlockingServlet {
	
	@Override
	protected JSONObject getResponse(JSONObject zParams) {
		
		//Which block..
		BlockRequest blkreq = new BlockRequest(zParams);
		
		PartialBlockIdentifier blk = blkreq.getPartialBlockIdentifier();
		
		testblock cblock = null;
		if(blk.isAnyDefined()) {
			
			if(blk.isIndexDefined()) {
				long index = blk.getIndex();
				cblock = testminima.getTestMinima().getBlockFromNum((int) index);
			}else {
				String hash = blk.getHash();
				cblock = testminima.getTestMinima().getBlockFromHash(hash);
			}
			
		}else {
			
			//Use top block
			cblock = testminima.getTestMinima().getTopBlock();
		}
		
		testblock parentblock 	= cblock;
		if(cblock.mBlockNumber != 0) {
			parentblock = testminima.getTestMinima().getBlockFromNum((int) (cblock.mBlockNumber-1));
		}
		
		Block block = new Block(	cblock.getBlockIdentifier(), 
									parentblock.getBlockIdentifier(), 
									cblock.mTimeStamp, 
									new ArrayList<>());
		
		BlockResponse blkresp = new BlockResponse(block, cblock.getTransactionIDs());
		
		return blkresp.getObject();
	}

}
