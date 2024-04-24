package com.minima.rosetta.testchain;

import java.util.ArrayList;

import com.minima.rosetta.Log;

public class testminima implements Runnable {
	
	static testminima mTestMinima 	= new testminima();
	public static testminima getTestMinima() {
		return mTestMinima;
	}
	
	public boolean mRunning = true;
	Thread mMainThread;
	
	ArrayList<testblock> mBlocks = new ArrayList<>();
	
	public testminima() {
		
		Log.log("Test Minima Chain Created");
		
		//Create a genesis block
		testblock genesis = createBlock(0);
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
	
	public testblock createBlock(long zBlockNumber) {
		testblock newblock = new testblock(zBlockNumber);
		return newblock;
	}
	
	@Override
	public void run() {
		
		Log.log("Start Block Builder..");
		
		//Create a new block Every 10 secs..
		try {
			while(mRunning) {
				
				Thread.sleep(5000);
		
				Log.log("Create NEW block..  @ "+getBlockNumber());
				mBlocks.add(createBlock(getBlockNumber()));
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
