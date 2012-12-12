package de.boeserwolf.bubblesort;

import de.boeserwolf.bubblesort.util.Interval;

public class Main
{

    public static void main(String[] args)
    {
        AnalysisLogger logger = AnalysisLogger.getInstance();
        
        Class clazz = Double.class;
        int lists = 500000;
        int elements = 10;
        int intervalLeft = 0;
        int intervalRight = 1;
        
        for(int i = 0; i < 10; i++)
        {
            BubbleSortAnalysis analysis = new BubbleSortAnalysis<>(clazz, lists, elements, new Interval(intervalLeft, intervalRight));
            logger.addResult(analysis);
        }
        
    }
}
