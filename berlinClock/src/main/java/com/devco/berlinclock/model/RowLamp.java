package com.devco.berlinclock.model;

public class RowLamp {

	private boolean arrayLamp[];

	public RowLamp(int size) {
		this.arrayLamp = new boolean[size];
	}

	public boolean[] getArrayLamp() {
		return arrayLamp;
	}

	public void turnOnLamp() {
		for (int i = 0; i < arrayLamp.length; i++) {
			if (!arrayLamp[i]) {
				arrayLamp[i] = true;
				break;
			}
		}
	}
	
	public int getNumberOfLampsOn(){
		int numberOfLampsOn = 0;
		for (int i = 0; i < arrayLamp.length; i++) {
			if (!arrayLamp[i]) {
				break;
			}
			numberOfLampsOn = i + 1;
		}
		return numberOfLampsOn;
	}
}
