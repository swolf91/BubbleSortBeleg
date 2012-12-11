package de.boeserwolf.bubblesort;

import de.boeserwolf.bubblesort.util.ComparableList;
import de.boeserwolf.bubblesort.util.Direction;
import de.boeserwolf.bubblesort.util.Interval;
import de.boeserwolf.bubblesort.util.NumberUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BubbleSortAnalysis<C extends Comparable> implements Iterable<ComparableList<C>>
{
    List<ComparableList<C>> lists;
    
    Map<Integer, Integer> absoluteFrequency;
    
    BubbleSortAnalysis(Class<C> type, int amountLists, int amountElements, Interval interval)
    {
        if(!type.equals(Integer.class) && !type.equals(Double.class))
        {
            throw new UnsupportedOperationException("Only Integer and Double values are permitted.");
        }
        this.lists = new ArrayList<>(amountLists);
        this.absoluteFrequency = new HashMap<>();
        
        for(int i = 0; i < amountLists; i++)
        {
            ComparableList<C> list = new ComparableList<>();
            
            for(int j = 0; j < amountElements; j++)
            {
                if(type.equals(Integer.class))
                {
                    list.add((C)Integer.valueOf( NumberUtil.getRandomInt(interval) ));
                }
                else if(type.equals(Double.class))
                {
                    list.add((C)Double.valueOf( NumberUtil.getRandomDouble(interval) ));
                }
            }
            
            this.lists.add(list);
            
            list.sort(Direction.ASC);
            this.addAbsFrequency(list.getReplacements());
        }
    }
    
    public Collection<Integer> getReplacementKeys()
    {
        return this.absoluteFrequency.keySet();
    }
    
    public int getAbsoluteFrequency(int key)
    {
        return this.absoluteFrequency.get(key);
    }
    
    public double getRelativeFrequency(int key)
    {
        return this.absoluteFrequency.get(key) / (double)this.getNumberOfLists();
    }
    
    public double getArithmeticAverage()
    {
        double avg = 0;
        
        for(Integer value : this.getReplacementKeys())
        {
            avg += value * this.getAbsoluteFrequency(value);
        }
        
        return avg / (double) this.getNumberOfLists();
    }
    
    public double getEmpiricalSpread()
    {
        double spread = 0;
        double avg = this.getArithmeticAverage();
        
        for(Integer value : this.getReplacementKeys())
        {
            spread += this.getAbsoluteFrequency(value) * Math.pow(value - avg, 2);
        }
        spread /= (double)(this.getNumberOfLists() - 1);
        return Math.sqrt(spread);
    }
    
    public Interval getConfidenzInterval95()
    {
        double avg = this.getArithmeticAverage();
        double spread = this.getEmpiricalSpread();
        
        return new Interval(avg - 1.96 * spread, avg + 1.96 * spread);
    }
    
    public ComparableList<C> getList(int index)
    {
        return this.lists.get(index);
    }
    
    public int getNumberOfLists()
    {
        return this.lists.size();
    }

    @Override
    public Iterator iterator()
    {
        return this.lists.iterator();
    }

    private void addAbsFrequency(int replacements) 
    {
        if(!this.absoluteFrequency.containsKey(replacements))
        {
            this.absoluteFrequency.put(replacements, 0);
        }
        this.absoluteFrequency.put(replacements, this.absoluteFrequency.get(replacements)+1);
    }
}
