package com.devco.berlinclock.model;

public class BerlinClockFormat {

	private static final String END_OF_LINE = "\n";
	
	private boolean secondsTopLamp;
	private RowLamp topHourLamps;
	private RowLamp lowerHourLamps;
	private RowLamp topMinuteLamps;
	private RowLamp lowerMinuteLamps;

	public BerlinClockFormat() {
		super();
		this.secondsTopLamp = false;
		this.topHourLamps = new RowLamp(4);
		this.lowerHourLamps = new RowLamp(4);
		this.topMinuteLamps = new RowLamp(11);
		this.lowerMinuteLamps = new RowLamp(4);
	}

	public boolean isSecondsTopLamp() {
		return secondsTopLamp;
	}

	public void setSecondsTopLamp(boolean secondsTopLamp) {
		this.secondsTopLamp = secondsTopLamp;
	}

	public void setTopHourLamps(RowLamp topHourLamps) {
		this.topHourLamps = topHourLamps;
	}

	public RowLamp getTopHourLamps() {
		return topHourLamps;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(secondsTopLamp ? "|Y|" : "|O|");
		sb.append(END_OF_LINE);
		for (boolean lampIterable : topHourLamps.getArrayLamp()) {
			sb.append(lampIterable ? "|R|" : "|O|");
		}
		sb.append(END_OF_LINE);
		for (boolean lampIterable : lowerHourLamps.getArrayLamp()) {
			sb.append(lampIterable ? "|R|" : "|O|");
		}
		sb.append(END_OF_LINE);
		for (int i = 0; i < topMinuteLamps.getArrayLamp().length; i++) {
			if (topMinuteLamps.getArrayLamp()[i]) {
				sb.append((i + 1) % 3 == 0 ? "|R|" : "|Y|");
			} else {
				sb.append("|O|");
			}
		}
		sb.append(END_OF_LINE);
		for (boolean lampIterable : lowerMinuteLamps.getArrayLamp()) {
			sb.append(lampIterable ? "|Y|" : "|O|");
		}

		return sb.toString();
	}

}
