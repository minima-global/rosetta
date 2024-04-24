package com.minima.rosetta.objects.predefined;

import com.minima.rosetta.objects.models.Amount;

public class MinimaAmount extends Amount {

	public MinimaAmount(String zValue) {
		super(zValue, new MinimaCurrency());
	}

}
