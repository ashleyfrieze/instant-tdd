package uk.co.ashleyfrieze.leapyear;

public class DateUtil {
    /**
     * Is leap year
     * @param year 4 digit year
     * @return true if leap year
     */
    public static boolean isLeapYear(int year) {
        return (year % 4) == 0;
    }
}
