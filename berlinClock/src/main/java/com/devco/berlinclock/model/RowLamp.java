package com.devco.berlinclock.model;

import java.util.Arrays;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arrayLamp);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RowLamp other = (RowLamp) obj;
		if (!Arrays.equals(arrayLamp, other.arrayLamp))
			return false;
		return true;
	}
	
	
	
	
}
