package de.boeserwolf.bubblesort;

import de.boeserwolf.bubblesort.util.Interval;

public class Main
{

    public static void main(String[] args)
    {
        BubbleSortAnalysis<Integer> analysis = new BubbleSortAnalysis<>(Integer.class, 50, 10, new Interval(1, 1000));

//        for(Integer value : analysis.getReplacementKeys())
//        {
//            System.out.println(value + ": " + analysis.getAbsoluteFrequency(value));
//        }
        System.out.println("Average: " + analysis.getAverage());
        System.out.println("Spread: " + analysis.getEmpiricalSpread());
        
        System.out.println("Interval: " + analysis.getConfidenzInterval95());
    }
}
