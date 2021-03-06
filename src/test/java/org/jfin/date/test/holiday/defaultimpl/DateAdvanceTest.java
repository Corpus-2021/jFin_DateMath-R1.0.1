/*
 * <p> <b>jFin, open source derivatives trade processing</b> </p>
 *
 * <p> Copyright (C) 2005, 2006, 2007 Morgan Brown Consultancy Ltd. </p>
 *
 * <p> This file is part of jFin. </p>
 *
 * <p> jFin is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. </p>
 *
 * <p> jFin is distributed in the hope that it will be useful, but <b>WITHOUT
 * ANY WARRANTY</b>; without even the implied warranty of <b>MERCHANTABILITY</b>
 * or <b>FITNESS FOR A PARTICULAR PURPOSE</b>. See the GNU General Public
 * License for more details. </p>
 *
 * <p> You should have received a copy of the GNU General Public License along
 * with jFin; if not, write to the Free Software Foundation, Inc., 51 Franklin
 * St, Fifth Floor, Boston, MA 02110-1301 USA. </p>
 */

package org.jfin.date.test.holiday.defaultimpl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.jfin.date.BusinessDayConvention;
import org.jfin.date.holiday.HolidayCalendar;
import org.jfin.date.holiday.HolidayCalendarException;
import org.jfin.date.holiday.HolidayCalendarFactory;

public class DateAdvanceTest extends TestCase
{

	public void testDaysBackwards()
	{
		advance(new GregorianCalendar(2006, 1, 10), -5, Calendar.DAY_OF_YEAR,
				new GregorianCalendar(2006, 1, 3));
	}

	public void testDaysForwards()
	{
		advance(new GregorianCalendar(2006, 1, 10), 5, Calendar.DAY_OF_YEAR,
				new GregorianCalendar(2006, 1, 17));
	}

	public void testBadAdvance()
	{
		try
		{
			advance(new GregorianCalendar(2005, 0, 10), 5, -1000,
					new GregorianCalendar(2005, 0, 15));
		} catch (HolidayCalendarException e)
		{
			return;
		}
		fail("Advance did not throw an exception even given an improper Calendar unit.");
	}

	public void advance(Calendar referenceCalendar, int amount, int unit,
			Calendar targetCalendar)
	{

		HolidayCalendarFactory holidayCalendarFactory = HolidayCalendarFactory
				.newInstance();
		HolidayCalendar wend = holidayCalendarFactory.getHolidayCalendar("WE");

		BusinessDayConvention unadjusted = BusinessDayConvention.UNADJUSTED;

		Calendar backTest = wend.advance(referenceCalendar, amount, unit,
				unadjusted);

		assertEquals(backTest, targetCalendar);

	}
}
