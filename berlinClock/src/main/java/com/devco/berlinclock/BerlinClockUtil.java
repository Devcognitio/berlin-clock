package com.devco.berlinclock;

import java.time.LocalTime;

import com.devco.berlinclock.model.BerlinClockFormat;

public class BerlinClockUtil {

	private static final BerlinClockUtil INSTANCE = new BerlinClockUtil();

	private BerlinClockUtil() {
	}

	public static BerlinClockUtil getInstance() {
		return INSTANCE;
	}

	public BerlinClockFormat format(LocalTime hourInput) {
		BerlinClockFormat result = new BerlinClockFormat();
		return result;
	}
	
	

}
