package de.boeserwolf.bubblesort.util;

public final class NumberUtil
{
    /**
     * Gibt eine zufällige ganze Zahl zurück
     * @param interval das Interval in dem die Zahl erzeugt werden soll
     * @return die erzeugte Zahl
     */
    public static int getRandomInt(Interval interval)
    {
        return (int) (Math.random() * Math.abs(1 + interval.rightLimit.doubleValue() - interval.leftLimit.doubleValue()) + interval.leftLimit.doubleValue());
    }

    /**
     * Gibt eine zufällige reelle Zahl zurück
     * @param interval das Intervall in dem die Zahl erzeugt werden soll
     * @return die erzeugte Zahl
     */
    public static double getRandomDouble(Interval interval)
    {
        return Math.random() * Math.abs(interval.rightLimit.doubleValue() - interval.leftLimit.doubleValue()) + interval.leftLimit.doubleValue();
    }
}
