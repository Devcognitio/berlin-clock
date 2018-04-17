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
		
		turnOnSecondsTopLamp(hourInput, result);
		turnOnTopHourLamps(hourInput, result);
		turnOnLowerHourLamps(hourInput, result);
		turnOnTopMinuteLamps(hourInput, result);
		turnOnLowerMinuteLamps(hourInput, result);
		
		return result;
	}
	
	private void turnOnSecondsTopLamp(LocalTime hourInput, BerlinClockFormat result) {
		result.setSecondsTopLamp(hourInput.getSecond() % 2 == 0);
	}

	//TODO mockearlo
	protected void turnOnTopHourLamps(LocalTime hourInput, BerlinClockFormat result) {
		for (int i = 0; i < numberOfTopHoursLampsToTurnOn(hourInput.getHour()); i++) {
			result.getTopHourLamps().turnOnLamp();
		}
	}

	private int numberOfTopHoursLampsToTurnOn(int hour) {
		return hour / 5;
	}
	
	//TODO POWERMOCK
	private void turnOnLowerHourLamps(LocalTime hourInput, BerlinClockFormat result) {
		for (int i = 0; i < numberOfLowerHoursLampsToTurnOn(hourInput.getHour()); i++) {
			result.getLowerHourLamps().turnOnLamp();
		}
	}
	
	private int numberOfLowerHoursLampsToTurnOn(int hour) {
		return hour % 5 ;
	}
	
	private void turnOnTopMinuteLamps(LocalTime hourInput, BerlinClockFormat result) {
		for (int i = 0; i < numberOfTopMinuteLampsToTurnOn(hourInput.getMinute()); i++) {
			result.getTopMinuteLamps().turnOnLamp();
		}
	}

	private int numberOfTopMinuteLampsToTurnOn(int minutes) {
		return minutes / 5;
	}
	
	private void turnOnLowerMinuteLamps(LocalTime hourInput, BerlinClockFormat result) {
		for (int i = 0; i < numberOfLowerMinuteLampsToTurnOn(hourInput.getMinute()); i++) {
			result.getLowerMinuteLamps().turnOnLamp();
		}
	}

	private int numberOfLowerMinuteLampsToTurnOn(int minute) {
		return minute % 5 ;
	}

}
