package de.boeserwolf.bubblesort.util.exception;

public class IllegalIntervalException extends RuntimeException 
{
    
    public IllegalIntervalException(String message)
    {
        super(message);
    }
    
    public IllegalIntervalException(String message, Throwable t)
    {
        super(message, t);
    }
    
}
