package de.boeserwolf.bubblesort.util;

import de.boeserwolf.bubblesort.util.exception.MissSortException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ComparableList<C extends Comparable> implements Iterable<C>
{
    private List<C> unsortedList;
    
    private Direction direction;
    private List<C> sortedList;
    private int replacements;
    private int replacementChecks;
    
    public ComparableList()
    {
        this.unsortedList = new ArrayList<>();
        this.sortedList = new ArrayList<>();
    }
    
    public ComparableList(Collection<C> collection)
    {
        this();
        unsortedList.addAll(collection);
    }
    
    public ComparableList(C[] comps)
    {
        this();
        this.unsortedList.addAll(Arrays.asList(comps));
    }
    
    public boolean add(C e)
    {
        this.sortedList.clear();
        return this.unsortedList.add(e);
    }
    
    public boolean addAll(Collection<C> c)
    {
        this.sortedList.clear();
        return this.addAll(c);
    }
    
    public void clear()
    {
        this.sortedList.clear();
        this.unsortedList.clear();
    }
    
    public boolean contains(C e)
    {
        return this.unsortedList.contains(e);
    }
    
    public boolean containsAll(Collection<C> c)
    {
        return this.unsortedList.containsAll(c);
    }
    
    public int size()
    {
        return this.unsortedList.size();
    }
    
    public C get(int index)
    {
        return this.unsortedList.get(index);
    }
    
    public int indexOf(C e)
    {
        return this.unsortedList.indexOf(e);
    }
    
    public int lastIndexOf(C e)
    {
        return this.unsortedList.lastIndexOf(e);
    }
    
    public boolean remove(C e)
    {
        this.sortedList.clear();
        return this.unsortedList.remove(e);
    }
    
    public C remove(int index)
    {
        this.sortedList.clear();
        return this.unsortedList.remove(index);
    }
    
    public boolean removeAll(Collection c)
    {
        this.sortedList.clear();
        return this.removeAll(c);
    }
    
    public void transactSortedList()
    {
        this.unsortedList = this.cloneSortedList();
    }
    
    public Collection<C> getUnsortedList()
    {
        return this.cloneUnsortedList();
    }
    
    public void sort(Direction direction)
    {
        this.direction = direction;
        this.replacements = 0;
        this.replacementChecks = 0;
        
        this.sortedList = this.cloneUnsortedList();
        C temp;
        boolean swapped;
        
        do
        {   
            swapped = false;
            for (int i = 0; i < this.sortedList.size() - 1; i++)
            {
                int sort = sortedList.get(i).compareTo(this.sortedList.get(i + 1));
                if ((direction.equals(Direction.ASC) && sort == 1) || (direction.equals(Direction.DESC) && sort == -1))
                {
                    temp = this.sortedList.get(i);
                    this.sortedList.set(i, this.sortedList.get(i + 1));
                    this.sortedList.set(i + 1, temp);

                    this.replacements++;
                    swapped = true;
                }
                this.replacementChecks++;
            }
        }
        while(swapped);
    }
    
    public Collection<C> getSortedList()
    {
        if (this.sortedList.size() != this.unsortedList.size())
        {
            throw new MissSortException("You did not sort your list.");
        }
        return this.sortedList;
    }
    
    public int getReplacementChecks()
    {
        if (this.sortedList.size() != this.unsortedList.size())
        {
            throw new MissSortException("You did not sort your list.");
        }
        return this.replacementChecks;
    }
    
    public int getReplacements()
    {
        if (this.sortedList.size() != this.unsortedList.size())
        {
            throw new MissSortException("You did not sort your list.");
        }
        return this.replacements;
    }

    public Direction getDirection()
    {
        if (this.sortedList.size() != this.unsortedList.size())
        {
            throw new MissSortException("You did not sort your list.");
        }
        return this.direction;
    }
    
    protected List<C> cloneUnsortedList()
    {
        List<C> list = new ArrayList<>(this.unsortedList.size());
        list.addAll(this.unsortedList);
        return list;
    }
    
    protected List<C> cloneSortedList()
    {
        List<C> list = new ArrayList<>(this.sortedList.size());
        list.addAll(this.sortedList);
        return list;
    }
    
    @Override
    public Iterator<C> iterator()
    {
        if(this.sortedList.size() == this.unsortedList.size())
        {
            return this.sortedList.iterator();
        }
        return this.unsortedList.iterator();
    }
}