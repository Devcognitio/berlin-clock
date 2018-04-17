package com.devco.berlinclock.model;

public class RowLamp {

	private boolean arrayLamp[];

	public RowLamp(int size) {
		this.arrayLamp = new boolean[size];
	}

	public boolean[] getArrayLamp() {
		return arrayLamp;
	}

}
