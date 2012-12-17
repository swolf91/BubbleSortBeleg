package de.boeserwolf.bubblesort;

import de.boeserwolf.bubblesort.util.ComparableList;
import de.boeserwolf.bubblesort.util.Direction;
import de.boeserwolf.bubblesort.util.Interval;

public class Main
{
    public static void main( String[] args )
    {
//        AnalysisLogger logger = AnalysisLogger.getInstance();
//        
//        Class clazz = Double.class;
//        int lists = 500;
//        int elements = 10;
//        int intervalLeft = 0;
//        int intervalRight = 1;
//        
//        for(int i = 0; i < 10; i++)
//        {
//            BubbleSortAnalysis analysis = new BubbleSortAnalysis<>(clazz, lists, elements, new Interval(intervalLeft, intervalRight));
//            logger.addResult(analysis);
//            System.out.println(analysis.getExpectation());
//            System.out.println(analysis.getStatisticalSpread());
//        }

        /*
         * t(n-1) = ( AVG - theoretischer Erwartungswert ) / sqrt( spread ) /
         * Sqrt(n)
         * http://de.wikipedia.org/wiki/Studentsche_t-Verteilung#Verwendung_in_der_mathematischen_Statistik
         */
        
        ComparableList<Double> list = new ComparableList<>();
        
        list.add( 0.1 );
        list.add( 0.2 );
        list.add( 0.25 );
        list.add( 0.46 );
        list.add( 0.47 );
        list.add( 0.53 );
        list.add( 0.645 );
        list.add( 0.723 );
        list.add( 0.835 );
        list.add( 0.98 );
        list.sort( Direction.ASC );
        
        System.out.println(list.getReplacements());
        System.out.println(list.getReplacementChecks());
    }
}
