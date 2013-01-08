    package de.boeserwolf.bubblesort;

import de.boeserwolf.bubblesort.util.ComparableList;
import de.boeserwolf.bubblesort.util.Direction;
import de.boeserwolf.bubblesort.util.Interval;
import de.boeserwolf.bubblesort.util.NumberUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BubbleSortAnalysis<C extends Comparable>
{
    private int amountLists;
    private int amountElementsPerList;
    private Interval interval;
    private Class elementClass;
    private Map<Integer, Integer> absoluteFrequency;

    BubbleSortAnalysis( Class<C> type, int amountLists, int amountElements, Interval interval )
    {
        if( !type.equals( Integer.class ) && !type.equals( Double.class ) )
        {
            throw new UnsupportedOperationException( "Only Integer and Double values are permitted." );
        }
        this.absoluteFrequency = new HashMap<>();
        this.amountLists = amountLists;
        this.amountElementsPerList = amountElements;
        this.interval = interval;
        this.elementClass = type;

        ComparableList<C> list = new ComparableList<>();

        for( int i = 0; i < amountLists; i++ )
        {
            for( int j = 0; j < amountElements; j++ )
            {
                if( type.equals( Integer.class ) )
                {
                    list.add( ( C ) Integer.valueOf( NumberUtil.getRandomInt( interval ) ) );
                }
                else if( type.equals( Double.class ) )
                {
                    list.add( ( C ) Double.valueOf( NumberUtil.getRandomDouble( interval ) ) );
                }
            }

            list.sort( Direction.ASC );
            this.addAbsFrequency( list.getReplacements() );
            
            list.clear();
        }
    }

    public Collection<Integer> getReplacementKeys()
    {
        return this.absoluteFrequency.keySet();
    }

    public int getAbsoluteFrequency( int key )
    {
        return this.absoluteFrequency.get( key );
    }

    public double getRelativeFrequency( int key )
    {
        return this.absoluteFrequency.get( key ) / ( double ) this.getNumberOfLists();
    }

    public Class getElementClass()
    {
        return this.elementClass;
    }

    public Interval getInterval()
    {
        return this.interval;
    }

    public double getAverage()
    {
        double avg = 0;

        for( Integer value : this.getReplacementKeys() )
        {
            avg += value * this.getAbsoluteFrequency( value );
        }

        return avg / ( double ) this.getNumberOfLists();
    }

    public double getEmpiricalSpread()
    {
        double spread = 0;
        double avg = this.getAverage();

        for( Integer value : this.getReplacementKeys() )
        {
            spread += this.getAbsoluteFrequency( value ) * Math.pow( value - avg, 2 );
        }
        spread /= ( double ) (this.getNumberOfLists() - 1);
        return spread;
    }

    public double getExpectation()
    {
        return this.getMaxReplacements() / 2.0;
    }

    public int getMaxReplacements()
    {
        return ( int ) (this.getNumberOfElementsPerList() * (this.getNumberOfElementsPerList() - 1) * 0.5);
    }

    public double getStatisticalSpread()
    {
        double value = 0;
        for(int i = 1; i < this.getNumberOfElementsPerList(); i++)
        {
            value += (this.getNumberOfElementsPerList() - i) / 12.0 * (this.getNumberOfElementsPerList() - i + 2);
        }
        return value;
    }

    public Interval getConfidenzInterval95()
    {
        double avg = this.getAverage();
        double spread = Math.sqrt( this.getEmpiricalSpread() );

        return new Interval( avg - 1.96 * spread, avg + 1.96 * spread );
    }

    public int getNumberOfLists()
    {
        return this.amountLists;
    }

    public int getNumberOfElementsPerList()
    {
        return this.amountElementsPerList;
    }

    private void addAbsFrequency( int replacements )
    {
        if( !this.absoluteFrequency.containsKey( replacements ) )
        {
            this.absoluteFrequency.put( replacements, 0 );
        }
        this.absoluteFrequency.put( replacements, this.absoluteFrequency.get( replacements ) + 1 );
    }
}
