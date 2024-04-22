package com.minima.rosetta.objects.predefined;

import com.minima.rosetta.objects.models.Error;

public class ErrorNoConnect extends Error {
	public ErrorNoConnect() {
		super(99, "Could not connect to Minima Server", true);
	}
}
