package de.boeserwolf.bubblesort;

import de.boeserwolf.bubblesort.util.Interval;

public class Main
{
    
    public static double exp(int n)
    {
        double value = 0;
        for(int i = 1; i < n; i++)
        {
            value += i;
        }
        return (n-1) * n * 0.5 - value * 0.5; // (n^2-n) / 2         - sum(i / 2)
    }
    
    public static void main( String[] args )
    {
//        AnalysisLogger logger = AnalysisLogger.getInstance();
//        
//        Class clazz = Double.class;
//        int numberOfAnalysises = 1;
//        int lists = 500000;
//        int elements = 100;
//        int intervalLeft = 0;
//        int intervalRight = 1;
//        
//        for(int i = 0; i < numberOfAnalysises; i++)
//        {
//            BubbleSortAnalysis analysis = new BubbleSortAnalysis<>(clazz, lists, elements, new Interval(intervalLeft, intervalRight));
//            logger.addResult(analysis);
//        }
        System.out.println("Exp 10: " + exp(10));
        System.out.println("Exp 5 : " + exp(5));
    }
}