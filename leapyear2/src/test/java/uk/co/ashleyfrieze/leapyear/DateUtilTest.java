package uk.co.ashleyfrieze.leapyear;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilTest {
    @Test
    public void normalLeapYearIsLeap() {
        assertTrue(DateUtil.isLeapYear(1992));
    }

    @Test
    public void normalLeapYearExample2IsLeap() {
        assertTrue(DateUtil.isLeapYear(1996));
    }

    @Test
    public void nonLeapYearIsNotLeap() {
        assertFalse(DateUtil.isLeapYear(1991));
    }

    @Test
    public void centuryYearsAreNotLeap() {
        assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    public void year2000WasLeap() {
        assertTrue(DateUtil.isLeapYear(2000));
    }
}