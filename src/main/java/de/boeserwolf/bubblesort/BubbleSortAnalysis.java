package de.boeserwolf.bubblesort;

import de.boeserwolf.bubblesort.util.ComparableList;
import de.boeserwolf.bubblesort.util.Interval;
import de.boeserwolf.bubblesort.util.NumberUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BubbleSortAnalysis<C extends Comparable> implements Iterable<ComparableList<C>>
{
    List<ComparableList<C>> lists;
    
    BubbleSortAnalysis(Class<C> type, int amountLists, int amountElements, Interval interval)
    {
        if(!type.equals(Integer.class) && !type.equals(Double.class))
        {
            throw new UnsupportedOperationException("Only Integer and Double values are permitted.");
        }
        this.lists = new ArrayList<>(amountLists);
        
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
        }
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
}
