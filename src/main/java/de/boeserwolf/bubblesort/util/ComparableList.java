package de.boeserwolf.bubblesort.util;

import de.boeserwolf.bubblesort.util.exception.MissSortException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ComparableList<C extends Comparable> implements Iterable<C>
{
    private List<C> list;
    
    private Direction direction;
    private int replacements;
    private int replacementChecks;
    
    public ComparableList()
    {
        this.list = new ArrayList<>();
    }
    
    public ComparableList(Collection<C> collection)
    {
        this();
        list.addAll(collection);
    }
    
    public ComparableList(C[] comps)
    {
        this();
        this.list.addAll(Arrays.asList(comps));
    }
    
    public boolean add(C e)
    {
        return this.list.add(e);
    }
    
    public boolean addAll(Collection<C> c)
    {
        return this.list.addAll(c);
    }
    
    public void clear()
    {
        this.list.clear();
    }
    
    public boolean contains(C e)
    {
        return this.list.contains(e);
    }
    
    public boolean containsAll(Collection<C> c)
    {
        return this.list.containsAll(c);
    }
    
    public int size()
    {
        return this.list.size();
    }
    
    public C get(int index)
    {
        return this.list.get(index);
    }
    
    public int indexOf(C e)
    {
        return this.list.indexOf(e);
    }
    
    public int lastIndexOf(C e)
    {
        return this.list.lastIndexOf(e);
    }
    
    public boolean remove(C e)
    {
        return this.list.remove(e);
    }
    
    public C remove(int index)
    {
        return this.list.remove(index);
    }
    
    public boolean removeAll(Collection c)
    {
        return this.list.removeAll(c);
    }
    
    public Collection<C> getList()
    {
        return this.cloneList();
    }
    
    public void sort(Direction direction)
    {
        this.direction = direction;
        this.replacements = 0;
        this.replacementChecks = 0;
        C temp;
        boolean swapped;
        
        do
        {   
            swapped = false;
            for (int i = 0; i < this.list.size() - 1; i++)
            {
                int sort = list.get(i).compareTo(this.list.get(i + 1));
                if ((direction.equals(Direction.ASC) && sort == 1) || (direction.equals(Direction.DESC) && sort == -1))
                {
                    temp = this.list.get(i);
                    this.list.set(i, this.list.get(i + 1));
                    this.list.set(i + 1, temp);

                    this.replacements++;
                    swapped = true;
                }
                this.replacementChecks++;
            }
        }
        while(swapped);
    }
    
    public int getReplacementChecks()
    {
        if (this.replacementChecks == 0)
        {
            throw new MissSortException("You did not sort your list.");
        }
        return this.replacementChecks;
    }
    
    public int getReplacements()
    {
        if (this.replacementChecks == 0)
        {
            throw new MissSortException("You did not sort your list.");
        }
        return this.replacements;
    }

    public Direction getDirection()
    {
        if (this.replacementChecks == 0)
        {
            throw new MissSortException("You did not sort your list.");
        }
        return this.direction;
    }
    
    protected List<C> cloneList()
    {
        List<C> list = new ArrayList<>(this.list.size());
        list.addAll(this.list);
        return list;
    }
    
    @Override
    public Iterator<C> iterator()
    {
        return this.list.iterator();
    }
}