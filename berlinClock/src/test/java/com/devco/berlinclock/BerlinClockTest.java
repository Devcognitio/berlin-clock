package com.devco.berlinclock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;


import java.time.LocalTime;

import org.junit.Test;

import com.devco.berlinclock.model.BerlinClockFormat;

public class BerlinClockTest {
	
// PATRON" |Y| \n- |R||R||R||R| \n- |R||R||R||R| \n- |Y||Y||R||Y||Y||R||Y||Y||R||Y||Y| \n- |Y||Y||Y||Y| "

	@Test
	public void shouldReturnBerlinClockFormatWithLocalTime16_53() {
		// Arrange
		BerlinClockUtil berlinClockUtil = BerlinClockUtil.getInstance();
		LocalTime hourInput = LocalTime.of(16, 53);

		// Act
		BerlinClockFormat resultado = berlinClockUtil.format(hourInput);

		// Assert
		String expectedBerlinClockString = "|Y| \n |R||R||R||O| \n |R||O||O||O| \n |Y||Y||R||Y||Y||R||Y||Y||R||Y||O| \n |Y||Y||Y||O|";
		assertThat(resultado, is(notNullValue()));
		assertThat(resultado.toString(), is(expectedBerlinClockString));
	}

}
