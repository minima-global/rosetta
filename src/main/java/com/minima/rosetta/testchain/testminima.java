package com.minima.rosetta.testchain;

import java.util.ArrayList;
import java.util.Hashtable;

import com.minima.rosetta.Log;
import com.minima.rosetta.objects.models.Amount;
import com.minima.rosetta.objects.models.Transaction;
import com.minima.rosetta.objects.predefined.MinimaAmount;

public class testminima implements Runnable {
	
	static testminima mTestMinima 	= new testminima();
	public static testminima getTestMinima() {
		return mTestMinima;
	}
	
	public boolean mRunning = true;
	Thread mMainThread;
	
	ArrayList<testblock> mBlocks 		 = new ArrayList<>();
	
	ArrayList<Transaction> mTransactions = new ArrayList<>();
	
	Hashtable<String, Integer> mBalances = new Hashtable<>();
	
	public testminima() {
		
		Log.log("Test Minima Chain Created");
		
		//Create the gensis txn
		genesistransaction gentran = new genesistransaction("0xFF", 1000);
		mTransactions.add(gentran.getTransaction());
		
		//Create a genesis block
		testblock genesis = new testblock(0,gentran.getTransaction());
		mBlocks.add(genesis);
		
		Log.log("Create NEW block..  @ 0 with Transaction "+gentran.getTransaction().getObject().toString());
		
		//Startup balances..
		mBalances.put("0xFF", new Integer("1000"));
		mBalances.put("0xEE", new Integer("0"));
		mBalances.put("0xDD", new Integer("0"));
	}

	public void start() {
		//Start a new block thread
		mMainThread = new Thread(this);
		mMainThread.start();
	}
	
	public void stop() {
		mRunning = false;
	}
	
	public Transaction getTransaction(String zTransID) {
		for(Transaction trans : mTransactions) {
			if(trans.getTransactionIdentifier().getHash().equals(zTransID)) {
				return trans;
			}
		}
		return null;
	}
	
	public testblock getTopBlock() {
		int len = mBlocks.size();
		return mBlocks.get(len-1);
	}
	
	public int getBlockNumber() {
		return mBlocks.size();
	}
	
	public testblock getGenesisBlock() {
		return mBlocks.get(0);
	}
	
	public testblock getBlockFromNum(int zBlock) {
		for(testblock block : mBlocks) {
			if(block.mBlockNumber == zBlock) {
				return block;
			}
		}
		
		return null;
	}
	
	public testblock getBlockFromHash(String zHash) {
		for(testblock block : mBlocks) {
			if(block.mBlockID.equals(zHash)) {
				return block;
			}
		}
		return null;
	}
	
	public MinimaAmount getBalance(String zAddress) {
		Integer bal = mBalances.get(zAddress);
		return new MinimaAmount(""+bal);
	}
	
	public void updateBalances(String zFrom, String zTo, int zAmount) {
		Integer frombal = mBalances.get(zFrom);
		Integer tobal 	= mBalances.get(zTo);
		
		int newfrombal  = frombal.intValue()-zAmount;
		int newtobal  	= tobal.intValue()+zAmount;
		
		mBalances.put(zFrom, new Integer(newfrombal));
		mBalances.put(zTo, new Integer(newtobal));
	}
	
	@Override
	public void run() {
		
		Log.log("Start Block Builder..");
		
		//Create a new block Every 10 secs..
		try {
			while(getBlockNumber()<10) {
				
				Thread.sleep(1000);
				
				testblock newblock = null;
				if(getBlockNumber() == 3) {
					
					//Get the Transaction
					Transaction trans = new customtransaction("0xFF", "0xEE", 100).getTransaction();
					mTransactions.add(trans);
					
					Log.log("Create NEW block..  @ "+getBlockNumber()+" with Transaction "+trans.getObject().toString());
					
					newblock = new testblock(getBlockNumber(),trans);
					
				}else if(getBlockNumber() == 5) {
					
					//Get the Transaction
					Transaction trans = new customtransaction("0xEE", "0xDD", 10).getTransaction();
					mTransactions.add(trans);
					
					Log.log("Create NEW block..  @ "+getBlockNumber()+" with Transaction "+trans.getObject().toString());
					
					newblock = new testblock(getBlockNumber(),trans);
					
				}else {
					Log.log("Create NEW block..  @ "+getBlockNumber());
					
					newblock = new testblock(getBlockNumber());
				} 
				
				mBlocks.add(newblock);
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.log("End Block Builder..");
	}
}
