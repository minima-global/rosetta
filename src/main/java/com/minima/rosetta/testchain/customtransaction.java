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

public class customtransaction {

	private static int COIN_COUNTER = 0;
	
	Transaction mTransaction;
	
	TransactionIdentifier mTransactionID;
	
	public customtransaction(String zFrom, String zTo, int zAmount) {
		
		//Update balances
		testminima.getTestMinima().updateBalances(zFrom, zTo, zAmount);
		
		Random rand 	= new Random();
		String ID 		= "0x"+Long.toHexString(rand.nextLong()).toUpperCase();
		
		mTransactionID = new TransactionIdentifier(ID);
		
		//Create an Operation that spends a coin..
		OperationIdentifier opid = new OperationIdentifier(0);
		AccountIdentifier accid = new AccountIdentifier(zFrom);
		Amount amm = new MinimaAmount(""+(zAmount*-1));
		
		//Create a Coin..
		CoinIdentifier ccid = new CoinIdentifier("0x"+Integer.toHexString(COIN_COUNTER++));
		CoinChange cc = new CoinChange(ccid, CoinChange.CoinAction.coin_spent);
		
		Operation input = new Operation(opid, 
										"transfer", 
										"SUCCESS", 
										accid, 
										amm, 
										cc);
		
		//Create an Operation that creates a coin..
		OperationIdentifier opid2 = new OperationIdentifier(1);
		AccountIdentifier accid2 = new AccountIdentifier(zTo);
		Amount amm2 = new MinimaAmount(""+zAmount);
		
		CoinIdentifier ccid2 = new CoinIdentifier("0x"+Integer.toHexString(COIN_COUNTER++));
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
