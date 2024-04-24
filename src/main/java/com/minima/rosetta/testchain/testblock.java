package com.minima.rosetta.testchain;

import java.util.ArrayList;
import java.util.Random;

import com.minima.rosetta.objects.identifiers.BlockIdentifier;
import com.minima.rosetta.objects.identifiers.TransactionIdentifier;
import com.minima.rosetta.objects.models.Transaction;

public class testblock {

	public long mTimeStamp 		= 0;
	public long mBlockNumber 	= -1;
	public String mBlockID 		= "";
	
	ArrayList<Transaction> mTransactions = new ArrayList<>();
	
	ArrayList<TransactionIdentifier> mTransactionIDs = new ArrayList<>();
	
	public testblock(long zNumber) {
		this(zNumber,null);
	}
	
	public testblock(long zNumber, Transaction zAddTransaction) {
		mBlockNumber 	= zNumber;
		
		Random rand 	= new Random();
		mBlockID 		= "0x"+Long.toHexString(rand.nextLong()).toUpperCase();;
		
		mTimeStamp 		= System.currentTimeMillis(); 
		
		if(zAddTransaction != null) {
			mTransactions.add(zAddTransaction);
			mTransactionIDs.add(zAddTransaction.getTransactionIdentifier());
		}
	}
	
	public BlockIdentifier getBlockIdentifier() {
		BlockIdentifier block = new BlockIdentifier(mBlockNumber, mBlockID);
		return block;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return mTransactions;
	}
	
	public ArrayList<TransactionIdentifier> getTransactionIDs() {
		return mTransactionIDs;
	}
}
