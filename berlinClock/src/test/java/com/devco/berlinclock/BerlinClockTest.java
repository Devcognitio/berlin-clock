package com.devco.berlinclock;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.devco.berlinclock.model.BerlinClockFormat;
import com.devco.berlinclock.model.RowLamp;

public class BerlinClockTest {
	

	@Test
	public void shouldReturnBerlinClockFormatWithLocalTime16_53_01() {
		BerlinClockUtil berlinClockUtil = BerlinClockUtil.getInstance();
		LocalTime hourInput = LocalTime.of(16, 53, 01);
		String expectedBerlinClockString = "|O|\n|R||R||R||O|\n|R||O||O||O|\n|Y||Y||R||Y||Y||R||Y||Y||R||Y||O|\n|Y||Y||Y||O|";
		BerlinClockFormat berlin = berlinClockUtil.format(hourInput);
		assertThat(berlin, is(notNullValue()));
		assertThat(berlin.toString(), is(expectedBerlinClockString));
	}

	@Test
	public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
		BerlinClockUtil berlinClockUtil = BerlinClockUtil.getInstance();
		LocalTime hourInput_16_53_00 = LocalTime.of(16, 53, 00);
		LocalTime hourInput_16_53_01 = LocalTime.of(16, 53, 01);
		LocalTime hourInput_16_53_59 = LocalTime.of(16, 53, 59);

		BerlinClockFormat berlin_16_53_00 = berlinClockUtil.format(hourInput_16_53_00);
		BerlinClockFormat berlin_16_53_01 = berlinClockUtil.format(hourInput_16_53_01);
		BerlinClockFormat berlin_16_53_59 = berlinClockUtil.format(hourInput_16_53_59);

		assertThat(berlin_16_53_00.isSecondsTopLamp(), is(true));
		assertThat(berlin_16_53_01.isSecondsTopLamp(), is(false));
		assertThat(berlin_16_53_59.isSecondsTopLamp(), is(false));
	}

	@Test
	public void testTopHoursShouldHave4Lamps() {
		BerlinClockUtil berlinClockUtil = BerlinClockUtil.getInstance();
		LocalTime hourInput_20_00_00 = LocalTime.of(20, 00, 00);
		LocalTime hourInput_22_00_00 = LocalTime.of(22, 00, 00);
		LocalTime hourInput_23_59_59 = LocalTime.of(23, 59, 59);

		BerlinClockFormat berlin_20_00_00 = berlinClockUtil.format(hourInput_20_00_00);
		BerlinClockFormat berlin_22_00_00 = berlinClockUtil.format(hourInput_22_00_00);
		BerlinClockFormat berlin_23_59_59 = berlinClockUtil.format(hourInput_23_59_59);

		assertThat(berlin_20_00_00.getTopHourLamps().getNumberOfLampsOn(), is(4));
		assertThat(berlin_22_00_00.getTopHourLamps().getNumberOfLampsOn(), is(4));
		assertThat(berlin_23_59_59.getTopHourLamps().getNumberOfLampsOn(), is(4));
	}

	@Test
	public void testBottomHoursShouldHave4Lamps() {
		BerlinClockUtil berlinClockUtil = BerlinClockUtil.getInstance();
		LocalTime hourInput_04_00_00 = LocalTime.of(04, 00, 00);
		LocalTime hourInput_09_00_00 = LocalTime.of(9, 00, 00);
		LocalTime hourInput_14_59_59 = LocalTime.of(14, 59, 59);
		LocalTime hourInput_19_59_59 = LocalTime.of(19, 59, 59);

		BerlinClockFormat berlin_04_00_00 = berlinClockUtil.format(hourInput_04_00_00);
		BerlinClockFormat berlin_09_00_00 = berlinClockUtil.format(hourInput_09_00_00);
		BerlinClockFormat berlin_14_59_59 = berlinClockUtil.format(hourInput_14_59_59);
		BerlinClockFormat berlin_19_59_59 = berlinClockUtil.format(hourInput_19_59_59);

		assertThat(berlin_04_00_00.getLowerHourLamps().getNumberOfLampsOn(), is(4));
		assertThat(berlin_09_00_00.getLowerHourLamps().getNumberOfLampsOn(), is(4));
		assertThat(berlin_14_59_59.getLowerHourLamps().getNumberOfLampsOn(), is(4));
		assertThat(berlin_19_59_59.getLowerHourLamps().getNumberOfLampsOn(), is(4));
	}

	// Top hours should light a red lamp for every 5 hours
	@Test
	public void testTopHoursShouldLightRedLampForEvery5Hours() {
		BerlinClockUtil berlinClockUtil = BerlinClockUtil.getInstance();
		LocalTime hourInput_00_00_00 = LocalTime.of(00, 00, 00);
		LocalTime hourInput_13_00_00 = LocalTime.of(13, 00, 00);
		LocalTime hourInput_23_59_59 = LocalTime.of(23, 59, 59);

		BerlinClockFormat berlin_00_00_00 = berlinClockUtil.format(hourInput_00_00_00);
		BerlinClockFormat berlin_13_00_00 = berlinClockUtil.format(hourInput_13_00_00);
		BerlinClockFormat berlin_23_59_59 = berlinClockUtil.format(hourInput_23_59_59);

		assertThat(berlin_00_00_00.getTopHourLamps().getNumberOfLampsOn(), is(0));
		assertThat(berlin_13_00_00.getTopHourLamps().getNumberOfLampsOn(), is(2));
		assertThat(berlin_23_59_59.getTopHourLamps().getNumberOfLampsOn(), is(4));
	}

	// Top minutes should have 11 lamps
	@Test
	public void testTopMinutesShouldHave11Lamps() {
		BerlinClockUtil berlinClockUtil = BerlinClockUtil.getInstance();
		LocalTime hourInput_00_55_00 = LocalTime.of(00, 55, 00);
		LocalTime hourInput_13_57_00 = LocalTime.of(13, 57, 00);
		LocalTime hourInput_23_59_59 = LocalTime.of(23, 59, 59);

		BerlinClockFormat berlin_00_55_00 = berlinClockUtil.format(hourInput_00_55_00);
		BerlinClockFormat berlin_13_57_00 = berlinClockUtil.format(hourInput_13_57_00);
		BerlinClockFormat berlin_23_59_59 = berlinClockUtil.format(hourInput_23_59_59);

		assertThat(berlin_00_55_00.getTopMinuteLamps().getNumberOfLampsOn(), is(11));
		assertThat(berlin_13_57_00.getTopMinuteLamps().getNumberOfLampsOn(), is(11));
		assertThat(berlin_23_59_59.getTopMinuteLamps().getNumberOfLampsOn(), is(11));
	}

	// Top minutes should have 3rd, 6th and 9th lamps in red to indicate first
	// quarter, half and last quarter
	@Test
	public void testTopMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
		BerlinClockUtil berlinClockUtil = BerlinClockUtil.getInstance();
		LocalTime hourInput_16_32_00 = LocalTime.of(16, 32, 00);
		String expectedBerlinClockString = "|Y|\n|R||R||R||O|\n|R||O||O||O|\n|Y||Y||R||Y||Y||R||O||O||O||O||O|\n|Y||Y||O||O|";

		BerlinClockFormat berlin_16_32_00 = berlinClockUtil.format(hourInput_16_32_00);

		assertThat(berlin_16_32_00.toString(), is(expectedBerlinClockString));
	}

	// Top minutes should light a yellow lamp for every 5 minutes unless it's
	// first quarter, half or last quarter
	@Test
	public void testTopMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
		BerlinClockUtil berlinClockUtil = BerlinClockUtil.getInstance();
		LocalTime hourInput_00_32_00 = LocalTime.of(00, 00, 00);
		LocalTime hourInput_00_17_00 = LocalTime.of(00, 17, 00);
		LocalTime hourInput_00_59_00 = LocalTime.of(00, 59, 00);
		String expectedBerlinClockString_00_32_00 = "|Y|\n|O||O||O||O|\n|O||O||O||O|\n|O||O||O||O||O||O||O||O||O||O||O|\n|O||O||O||O|";
		String expectedBerlinClockString_00_17_00 = "|Y|\n|O||O||O||O|\n|O||O||O||O|\n|Y||Y||R||O||O||O||O||O||O||O||O|\n|Y||Y||O||O|";
		String expectedBerlinClockString_00_59_00 = "|Y|\n|O||O||O||O|\n|O||O||O||O|\n|Y||Y||R||Y||Y||R||Y||Y||R||Y||Y|\n|Y||Y||Y||Y|";

		BerlinClockFormat berlin_00_32_00 = berlinClockUtil.format(hourInput_00_32_00);
		BerlinClockFormat berlin_00_17_00 = berlinClockUtil.format(hourInput_00_17_00);
		BerlinClockFormat berlin_00_59_00 = berlinClockUtil.format(hourInput_00_59_00);

		assertThat(berlin_00_32_00.toString(), is(expectedBerlinClockString_00_32_00));
		assertThat(berlin_00_17_00.toString(), is(expectedBerlinClockString_00_17_00));
		assertThat(berlin_00_59_00.toString(), is(expectedBerlinClockString_00_59_00));

	}
	
	
	@Test
	public void testturnOnTopHourLampsShouldReturnMock(){
		LocalTime hourInput_16_17_00 = LocalTime.of(16, 17, 00);
		BerlinClockFormat berlinClockMock = new BerlinClockFormat();
		RowLamp rowLamp = new RowLamp(4);
		berlinClockMock.setTopHourLamps(rowLamp);
		BerlinClockUtil berlinClockUtilMock = mock(BerlinClockUtil.class);
		Mockito.when(berlinClockUtilMock
				.turnOnTopHourLamps(isA(LocalTime.class), isA(BerlinClockFormat.class)))
				.thenReturn(berlinClockMock);
		
		String expectedBerlinClockString_16_17_00 = "|O|\n|O||O||O||O|\n|O||O||O||O|\n|O||O||O||O||O||O||O||O||O||O||O|\n|O||O||O||O|";
		
		BerlinClockFormat berlin_16_17_00 = berlinClockUtilMock.turnOnTopHourLamps(hourInput_16_17_00, berlinClockMock);	
		assertThat(berlin_16_17_00.toString(), is(expectedBerlinClockString_16_17_00));
	}

}
