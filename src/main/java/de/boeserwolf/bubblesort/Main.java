package de.boeserwolf.bubblesort;

import de.boeserwolf.bubblesort.util.ComparableList;
import de.boeserwolf.bubblesort.util.Interval;

public class Main
{

    public static void main(String[] args)
    {
        BubbleSortAnalysis<Double> analysis = new BubbleSortAnalysis<>(Double.class, 5, 5, new Interval(1, 20));
        
        for(ComparableList<Double> list : analysis)
        {
            for(Double value : list)
            {
                System.out.print(value + ", ");
            }
            System.out.println();
        }
        
    }
}
