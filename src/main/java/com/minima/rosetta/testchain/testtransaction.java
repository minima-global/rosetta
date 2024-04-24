package com.minima.rosetta.testchain;

import java.util.ArrayList;
import java.util.Random;

import com.minima.rosetta.objects.identifiers.AccountIdentifier;
import com.minima.rosetta.objects.identifiers.CoinIdentifier;
import com.minima.rosetta.objects.identifiers.OperationIdentifier;
import com.minima.rosetta.objects.identifiers.TransactionIdentifier;
import com.minima.rosetta.objects.models.Amount;
import com.minima.rosetta.objects.models.CoinChange;
import com.minima.rosetta.objects.models.Operation;
import com.minima.rosetta.objects.models.Transaction;
import com.minima.rosetta.objects.predefined.MinimaAmount;

public class testtransaction {

	Transaction mTransaction;
	
	TransactionIdentifier mTransactionID;
	
	public testtransaction() {
		
		Random rand 	= new Random();
		String ID 		= "0x"+Long.toHexString(rand.nextLong()).toUpperCase();;
		
		mTransactionID = new TransactionIdentifier("0xDEAD");
		
		//Create an Operation that spends a coin..
		OperationIdentifier opid = new OperationIdentifier(0);
		AccountIdentifier accid = new AccountIdentifier("0xFF");
		Amount amm = new MinimaAmount("100000");
		
		CoinIdentifier ccid = new CoinIdentifier("0x01");
		CoinChange cc = new CoinChange(ccid, CoinChange.CoinAction.coin_spent);
		
		Operation input = new Operation(opid, 
										"transfer", 
										"SUCCESS", 
										accid, 
										amm, 
										cc);
		
		//Create an Operation that creates a coin..
		OperationIdentifier opid2 = new OperationIdentifier(1);
		AccountIdentifier accid2 = new AccountIdentifier("0xEE");
		Amount amm2 = new MinimaAmount("100000");
		
		CoinIdentifier ccid2 = new CoinIdentifier("0x02");
		CoinChange cc2 = new CoinChange(ccid2, CoinChange.CoinAction.coin_created);
		
		Operation output = new Operation(opid2, 
										"transfer", 
										"SUCCESS", 
										accid2, 
										amm2, 
										cc2);
				
		
		//Add operations.. 
		ArrayList<Operation> allops = new ArrayList<>();
		allops.add(input);
		allops.add(output);
		
		//Now create the Transaction
		mTransaction = new Transaction(mTransactionID, allops);
	}
	
	public Transaction getTransaction() {
		return mTransaction;
	}
}
