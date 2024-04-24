package com.minima.rosetta.endpoints;

import java.util.ArrayList;

import org.json.JSONObject;

import com.minima.rosetta.jetty.BlockingServlet;
import com.minima.rosetta.objects.identifiers.BlockIdentifier;
import com.minima.rosetta.objects.models.Peer;
import com.minima.rosetta.objects.response.NetworkStatusResponse;
import com.minima.rosetta.testchain.testblock;
import com.minima.rosetta.testchain.testminima;

public class networkStatus extends BlockingServlet {

	@Override
	protected JSONObject getResponse(JSONObject zParams) {
		
		//Use the testminima
		testminima tminima 		= testminima.getTestMinima();
		testblock topblock 		= tminima.getTopBlock();
		testblock genesisblock 	= tminima.getGenesisBlock();
		
		//Get some details..
		//BlockIdentifier current 	= new BlockIdentifier(1, "0x01");
		//BlockIdentifier genesis		= new BlockIdentifier(0, "0x00");
		//BlockIdentifier oldest		= new BlockIdentifier(0, "0x00");
		
		BlockIdentifier current 	= topblock.getBlockIdentifier();
		BlockIdentifier genesis		= genesisblock.getBlockIdentifier();;
		BlockIdentifier oldest		= genesisblock.getBlockIdentifier();;
		
		Peer peer1 = new Peer("0xFF");
		
		ArrayList<Peer> allpeers = new ArrayList<>();
		allpeers.add(peer1);
		
		//Create Network Status rtesponse message..
		NetworkStatusResponse nsr = 
				new NetworkStatusResponse(	current, 
											topblock.mTimeStamp, 
											genesis, 
											oldest, 
											allpeers);
		
		return nsr.getObject();
	}
	
}
