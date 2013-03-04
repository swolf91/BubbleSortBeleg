package de.boeserwolf.bubblesort;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalysisLogger 
{   
    private static AnalysisLogger instance;
    private Logger logger;
    
    /**
     * erzeugt einen Datenlogger
     * @throws IOException 
     */
    private AnalysisLogger() throws IOException
    {
        this.logger = Logger.getLogger("bubbleSortAnalysis");
        FileHandler fileHandler = new FileHandler("./log.txt", true);
        fileHandler.setFormatter(new AnalysisFormatter());
        this.logger.addHandler(fileHandler);
    }
    
    /**
     * gibt eine Instanz der Klasse zurück
     * @return 
     */
    public static AnalysisLogger getInstance()
    {
        if(instance == null)
        {
            try 
            {
                instance = new AnalysisLogger();
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
        return instance;
    }
    
    /**
     * fügt einen Statistikeintrag in die Datei
     * @param analysis 
     */
    public void addResult(BubbleSortAnalysis analysis)
    {
        this.logInfo(
                "Number Of Lists:\t\t" + analysis.getNumberOfLists(),
                "Number Of Elements Per List:\t" + analysis.getNumberOfElementsPerList(),
                "Interval:\t\t\t" + analysis.getInterval(),
                "Type:\t\t\t\t" + analysis.getElementClass().getSimpleName(),
                "Expectation:\t\t\t" + analysis.getExpectation(),
                "Avarage:\t\t\t" + analysis.getAverage(),
                "Statistical Variance:\t\t" + analysis.getStatisticalVariance(),
                "Empirical Variance:\t\t" + analysis.getEmpiricalVariance(),
                "ConfidenzInterval 95%:\t\t" + analysis.getConfidenzInterval95()
        );
    }
    
    /**
     * loggt Nachrichten mithilfe des Datenloggers
     * @param message 
     */
    public void logInfo(String message)
    {
        this.logger.log(Level.INFO, message);
    }
    
    /**
     * loggt Nachrichten
     * @param params 
     */
    public void logInfo(String ... params)
    {
        if(params != null)
        {
            String message = params[0];
        
            for(int i = 1; i < params.length; i++)
            {
                message += "\n" + params[i];
            }
            this.logInfo(message);
        }
    }
}
