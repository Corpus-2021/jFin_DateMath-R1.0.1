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

package org.jfin.date.test.util;

import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.jfin.date.util.ISDADateFormat;

public class ISDACalendarFormatTest extends TestCase
{
	public void testInstantiation()
	{
		new ISDADateFormat();
	}

	public void testNullCalendar()
	{
		assertNull(ISDADateFormat.format(null));
		assertNull(ISDADateFormat.formatFixedLength(null));
	}

	public void testFormat()
	{
		assertEquals(ISDADateFormat.format(new GregorianCalendar(2005, 0, 1)),
				"2005/1/1");
		assertEquals(ISDADateFormat.format(new GregorianCalendar(2005, 9, 1)),
				"2005/10/1");
		assertEquals(ISDADateFormat.format(new GregorianCalendar(2005, 5, 10)),
				"2005/6/10");
		assertEquals(
				ISDADateFormat.format(new GregorianCalendar(2005, 10, 20)),
				"2005/11/20");
	}

	public void testFormatFixedLength()
	{
		assertEquals(ISDADateFormat.formatFixedLength(new GregorianCalendar(
				2005, 0, 1)), "2005/01/01");
		assertEquals(ISDADateFormat.formatFixedLength(new GregorianCalendar(
				2005, 9, 1)), "2005/10/01");
		assertEquals(ISDADateFormat.formatFixedLength(new GregorianCalendar(
				2005, 5, 10)), "2005/06/10");
		assertEquals(ISDADateFormat.formatFixedLength(new GregorianCalendar(
				2005, 10, 20)), "2005/11/20");
	}
}
