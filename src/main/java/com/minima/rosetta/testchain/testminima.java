package com.minima.rosetta.testchain;

import java.util.ArrayList;

import com.minima.rosetta.Log;
import com.minima.rosetta.objects.models.Transaction;

public class testminima implements Runnable {
	
	static testminima mTestMinima 	= new testminima();
	public static testminima getTestMinima() {
		return mTestMinima;
	}
	
	public boolean mRunning = true;
	Thread mMainThread;
	
	ArrayList<testblock> mBlocks 		 = new ArrayList<>();
	
	ArrayList<Transaction> mTransactions = new ArrayList<>();
	
	
	
	public testminima() {
		
		Log.log("Test Minima Chain Created");
		
		//Create a genesis block
		testblock genesis = new testblock(0);
		mBlocks.add(genesis);
	}

	public void start() {
		//Start a new block thread
		mMainThread = new Thread(this);
		mMainThread.start();
	}
	
	public void stop() {
		mRunning = false;
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
	
	@Override
	public void run() {
		
		Log.log("Start Block Builder..");
		
		//Create a new block Every 10 secs..
		try {
			while(getBlockNumber()<10) {
				
				Thread.sleep(1000);
				
				testblock newblock = null;
				if(getBlockNumber() == 3) {
					//Add a transaction
					testtransaction tt = new testtransaction();
					
					//Get the Transaction
					Transaction trans = tt.getTransaction();
					
					//Add to our list
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
