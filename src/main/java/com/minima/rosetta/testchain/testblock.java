package com.minima.rosetta.testchain;

import java.util.ArrayList;
import java.util.Random;

import com.minima.rosetta.objects.identifiers.BlockIdentifier;
import com.minima.rosetta.objects.models.Transaction;

public class testblock {

	public long mTimeStamp 		= 0;
	public long mBlockNumber 	= -1;
	public String mBlockID 		= "";
	
	public testblock(long zNumber) {
		mBlockNumber 	= zNumber;
		
		Random rand 	= new Random();
		mBlockID 		= "0x"+Long.toHexString(rand.nextLong()).toUpperCase();;
		
		mTimeStamp 		= System.currentTimeMillis(); 
	}
	
	public BlockIdentifier convertTestBlock() {
		BlockIdentifier block = new BlockIdentifier(mBlockNumber, mBlockID);
		return block;
	}
}
