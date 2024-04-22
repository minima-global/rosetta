package com.minima.rosetta.endpoints;

import java.util.ArrayList;

import org.json.JSONObject;

import com.minima.rosetta.jetty.BlockingServlet;
import com.minima.rosetta.objects.identifiers.BlockIdentifier;
import com.minima.rosetta.objects.models.Peer;
import com.minima.rosetta.objects.response.NetworkStatusResponse;

public class networkStatus extends BlockingServlet {

	@Override
	protected JSONObject getResponse(JSONObject zParams) {
		
		//Fist talk to Minima..
		//..
		
		//Get some details..
		BlockIdentifier current 	= new BlockIdentifier(1, "0x01");
		long currenttime 			= System.currentTimeMillis();
		
		BlockIdentifier genesis		= new BlockIdentifier(1, "0x00");
		BlockIdentifier oldest		= new BlockIdentifier(1, "0x00");
		
		Peer peer1 = new Peer("0xFF");
		
		ArrayList<Peer> allpeers = new ArrayList<>();
		allpeers.add(peer1);
		
		//Create Network Status rtesponse message..
		NetworkStatusResponse nsr = 
				new NetworkStatusResponse(	current, currenttime, 
											genesis, oldest, allpeers);
		
		return nsr.getObject();
	}
	
}
