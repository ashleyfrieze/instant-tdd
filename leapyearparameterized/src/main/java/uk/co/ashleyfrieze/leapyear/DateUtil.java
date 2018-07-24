package uk.co.ashleyfrieze.leapyear;

public class DateUtil {
    /**
     * Java doc...
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        return isDivisibleBy(year, 4) &&
                (!isDivisibleBy(year, 100) ||
                isDivisibleBy(year, 400));
    }

    private static boolean isDivisibleBy(int year, int divisor) {
        return year % divisor == 0;
    }
}
