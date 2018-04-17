package com.devco.berlinclock.model;

public class BerlinClockFormat {

	private boolean topLamp;
	private RowLamp topHourLamps;
	private RowLamp lowerHourLamps;
	private RowLamp topMinuteLamps;
	private RowLamp lowerMinuteLamps;

	public BerlinClockFormat() {
		super();
		this.topLamp = false;
		this.topHourLamps = new RowLamp(4);
		this.lowerHourLamps = new RowLamp(4);
		this.topMinuteLamps = new RowLamp(11);
		this.lowerMinuteLamps = new RowLamp(4);
	}
	
	public boolean isTopLamp() {
		return topLamp;
	}

	public void setTopLamp(boolean topLamp) {
		this.topLamp = topLamp;
	}

	public RowLamp getTopHourLamps() {
		return topHourLamps;
	}

	public void setTopHourLamps(RowLamp topHourLamps) {
		this.topHourLamps = topHourLamps;
	}

	public RowLamp getLowerHourLamps() {
		return lowerHourLamps;
	}

	public void setLowerHourLamps(RowLamp lowerHourLamps) {
		this.lowerHourLamps = lowerHourLamps;
	}

	public RowLamp getTopMinuteLamps() {
		return topMinuteLamps;
	}

	public void setTopMinuteLamps(RowLamp topMinuteLamps) {
		this.topMinuteLamps = topMinuteLamps;
	}

	public RowLamp getLowerMinuteLamps() {
		return lowerMinuteLamps;
	}

	public void setLowerMinuteLamps(RowLamp lowerMinuteLamps) {
		this.lowerMinuteLamps = lowerMinuteLamps;
	}
}
