package de.boeserwolf.bubblesort.util;

public final class NumberUtil
{
    public static int getRandomInt(Interval interval)
    {
        return (int) (Math.random() * Math.abs(1 + interval.rightLimit.doubleValue() - interval.leftLimit.doubleValue()) + interval.leftLimit.doubleValue());
    }

    public static double getRandomDouble(Interval interval)
    {
        return Math.random() * Math.abs(interval.rightLimit.doubleValue() - interval.leftLimit.doubleValue()) + interval.leftLimit.doubleValue();
    }
}
