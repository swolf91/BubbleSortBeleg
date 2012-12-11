package de.boeserwolf.bubblesort.util;

import de.boeserwolf.bubblesort.util.exception.IllegalIntervalException;

/**
 * represents a real interval 
 * @author Wolfi
 * @param <V> 
 */
public class Interval <V extends Number>
{
    public final V leftLimit;
    public final V rightLimit;
    
    public Interval(V left, V right)
    {
        this.leftLimit = left;
        this.rightLimit = right;
        
        if( leftLimit.doubleValue() > rightLimit.doubleValue() )
        {
            throw new IllegalIntervalException("It's not a valid interval");
        }
    }
}
