package de.boeserwolf.bubblesort.util;

import de.boeserwolf.bubblesort.util.exception.MissSortException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Verwalten von Instanzen von Klassen, die Comparable implementieren. 
 * Ermöglicht das Sortieren Instanzen mittels Bubblesort.
 * @author wolfi
 * @param <C> Klasse, die Comparable implementiert
 */
public class ComparableList<C extends Comparable> implements Iterable<C>
{
    private List<C> list;
    
    private Direction direction;
    private int replacements;
    private int replacementChecks;
    
    /**
     * Erstellt eine Instanz der Klasse ohne Elemente
     */
    public ComparableList()
    {
        this.list = new ArrayList<>();
        
        this.replacementChecks = 0;
        this.replacements = 0;
    }
    
    /**
     * Erstellt eine Instanz der Klasse, welche die Elemente der Collection enthält
     * @param collection Elemente die enthalten werden sollen
     */
    public ComparableList(Collection<C> collection)
    {
        this();
        list.addAll(collection);
    }
    
    /**
     * Erstellt eine Instanz der Klasse, welche die Elemente des Arrays enthält
     * @param comps Elemente die enthalten werden sollen
     */
    public ComparableList(C[] comps)
    {
        this();
        this.list.addAll(Arrays.asList(comps));
    }
    
    /**
     * Fügt ein Element hinzu
     * @param e das Element das hinzugefügt werden soll
     * @return 
     */
    public boolean add(C e)
    {
        return this.list.add(e);
    }
    
    /**
     * Fügt mehrere Elemente hinzu
     * @param c die Elemente die hinzugefügt werden sollen
     * @return 
     */
    public boolean addAll(Collection<C> c)
    {
        return this.list.addAll(c);
    }
    
    /**
     * leert die Liste
     */
    public void clear()
    {
        this.list.clear();
        this.replacementChecks = 0;
        this.replacements = 0;
    }
    
    /**
     * prüft ob die Liste das Element enthält
     * @param e das Element das überprüft werden soll
     * @return boolean ob das Element enthalten ist oder nicht
     */
    public boolean contains(C e)
    {
        return this.list.contains(e);
    }
    
    /**
     * prüft ob die Liste die Elemente enthält
     * @param c die Elemente die enthalten werden sollen
     * @return boolean
     */
    public boolean containsAll(Collection<C> c)
    {
        return this.list.containsAll(c);
    }
    
    /**
     * Die Anzahl der Elemente in der Liste
     * @return Anzahl der Elemente der Liste
     */
    public int size()
    {
        return this.list.size();
    }
    
    /**
     * Gibt ein Element der Liste zurück
     * @param index der Index des Elements dass zurückgegeben werden soll
     * @return das Element
     */
    public C get(int index)
    {
        return this.list.get(index);
    }
    
    /**
     * gibt den ersten Index des Elementes zurück
     * @param e das Element von dem der Index ermittelt werden soll
     * @return den Index oder -1, wenn das Element nicht enthalten ist
     */
    public int indexOf(C e)
    {
        return this.list.indexOf(e);
    }
    
    /**
     * gibt den letzten Index des Elementes zurück
     * @param e des Element
     * @return den Index oder -1, wenn das Element nicht enthalten ist
     */
    public int lastIndexOf(C e)
    {
        return this.list.lastIndexOf(e);
    }
    
    /**
     * löscht ein Element aus der Liste
     * @param e Element
     * @return boolean ob das Element gelöscht werden konnte oder nicht.
     */
    public boolean remove(C e)
    {
        return this.list.remove(e);
    }
    
    /**
     * löscht ein Element aus der Liste
     * @param index Index des Elementes
     * @return boolean ob das Element gelöscht werden konnte oder nicht
     */
    public C remove(int index)
    {
        return this.list.remove(index);
    }
    
    /**
     * löscht mehrere Elemente aus der Liste
     * @param c Elemente die zu löschen sind
     * @return boolean
     */
    public boolean removeAll(Collection c)
    {
        return this.list.removeAll(c);
    }
    
    /**
     * gibt die komplette Liste zurück
     * @return die Liste
     */
    public Collection<C> getList()
    {
        return this.cloneList();
    }
    
    /**
     * sortiert die Liste mithilfe von Bubblesort
     * @param direction Die Richtung in der die Liste sortiert werden soll
     */
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
    
    /**
     * Gibt zurück wie oft geprüft wurde, ob zwei 
     * Elemente miteinander vertauscht werden musste oder nicht
     * @return die Anzahl
     */
    public int getReplacementChecks()
    {
        if (this.replacementChecks == 0)
        {
            throw new MissSortException("You did not sort your list.");
        }
        return this.replacementChecks;
    }
    
    /**
     * Gibt zurück wie oft ein Element vertauscht wurde
     * @return Anzahl
     */
    public int getReplacements()
    {
        if (this.replacementChecks == 0)
        {
            throw new MissSortException("You did not sort your list.");
        }
        return this.replacements;
    }

    /**
     * Gibt die Richtung in der sortiert wurde zurück
     * @return Richtung
     */
    public Direction getDirection()
    {
        if (this.replacementChecks == 0)
        {
            throw new MissSortException("You did not sort your list.");
        }
        return this.direction;
    }
    
    /**
     * Erstellt eine Kopie der Liste
     * @return 
     */
    protected List<C> cloneList()
    {
        List<C> list = new ArrayList<>(this.list.size());
        list.addAll(this.list);
        return list;
    }
    
    /**
     * Gibt einen Iterator über die Elemente zurück
     * @return einen Listeniterator
     */
    @Override
    public Iterator<C> iterator()
    {
        return this.list.iterator();
    }
}