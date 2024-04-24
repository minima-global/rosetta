package com.minima.rosetta.objects.predefined;

import org.json.JSONObject;

import com.minima.rosetta.objects.models.Currency;

public class MinimaCurrency extends Currency {

	public MinimaCurrency() {
		super("MNMA", 2, new JSONObject());
	}

}
