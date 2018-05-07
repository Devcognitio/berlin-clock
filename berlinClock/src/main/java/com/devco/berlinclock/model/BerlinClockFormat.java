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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lowerHourLamps == null) ? 0 : lowerHourLamps.hashCode());
		result = prime * result + ((lowerMinuteLamps == null) ? 0 : lowerMinuteLamps.hashCode());
		result = prime * result + (secondsTopLamp ? 1231 : 1237);
		result = prime * result + ((topHourLamps == null) ? 0 : topHourLamps.hashCode());
		result = prime * result + ((topMinuteLamps == null) ? 0 : topMinuteLamps.hashCode());
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
		BerlinClockFormat other = (BerlinClockFormat) obj;
		if (lowerHourLamps == null) {
			if (other.lowerHourLamps != null)
				return false;
		} else if (!lowerHourLamps.equals(other.lowerHourLamps))
			return false;
		if (lowerMinuteLamps == null) {
			if (other.lowerMinuteLamps != null)
				return false;
		} else if (!lowerMinuteLamps.equals(other.lowerMinuteLamps))
			return false;
		if (secondsTopLamp != other.secondsTopLamp)
			return false;
		if (topHourLamps == null) {
			if (other.topHourLamps != null)
				return false;
		} else if (!topHourLamps.equals(other.topHourLamps))
			return false;
		if (topMinuteLamps == null) {
			if (other.topMinuteLamps != null)
				return false;
		} else if (!topMinuteLamps.equals(other.topMinuteLamps))
			return false;
		return true;
	}

	
	
}
