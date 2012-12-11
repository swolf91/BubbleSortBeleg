package de.boeserwolf.bubblesort;

import de.boeserwolf.bubblesort.util.ComparableList;
import de.boeserwolf.bubblesort.util.Interval;

public class Main
{

    public static void main(String[] args)
    {
        BubbleSortAnalysis<Integer> analysis = new BubbleSortAnalysis<>(Integer.class, 50000000, 10, new Interval(1, 20));
//        
//        for(ComparableList<Integer> list : analysis)
//        {
//            for(Integer value : list)
//            {
//                System.out.print(value + ", ");
//            }
//            System.out.print("\tRepl: " + list.getReplacements() + "\tChecks: " + list.getReplacementChecks());
//            System.out.println();
//        }
//        for(Integer value : analysis.getReplacementKeys())
//        {
//            System.out.println(value + ": " + analysis.getAbsoluteFrequency(value));
//        }
        System.out.println("Average: " + analysis.getArithmeticAverage());
        System.out.println("Spread: " + analysis.getEmpiricalSpread());
        
        System.out.println("Interval: " + analysis.getConfidenzInterval95());
    }
}
