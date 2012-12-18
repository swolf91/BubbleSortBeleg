package de.boeserwolf.bubblesort;

import de.boeserwolf.bubblesort.util.Interval;

public class Main
{
    public static void main( String[] args )
    {
        AnalysisLogger logger = AnalysisLogger.getInstance();
        
        Class clazz = Double.class;
        int numberOfAnalysises = 1;
        int lists = 500000;
        int elements = 100;
        int intervalLeft = 0;
        int intervalRight = 1;
        
        for(int i = 0; i < numberOfAnalysises; i++)
        {
            BubbleSortAnalysis analysis = new BubbleSortAnalysis<>(clazz, lists, elements, new Interval(intervalLeft, intervalRight));
            logger.addResult(analysis);
        }
    }
}
