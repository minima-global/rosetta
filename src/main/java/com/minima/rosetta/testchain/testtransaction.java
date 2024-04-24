package com.minima.rosetta.testchain;

import java.util.Random;

import com.minima.rosetta.objects.identifiers.TransactionIdentifier;

public class testtransaction {

	TransactionIdentifier transID;
	
	public testtransaction() {
		
		Random rand 	= new Random();
		String ID 		= "0x"+Long.toHexString(rand.nextLong()).toUpperCase();;
		
		transID = new TransactionIdentifier(ID);
		
		
		
	}
}
