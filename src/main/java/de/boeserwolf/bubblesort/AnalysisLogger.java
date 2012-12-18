package de.boeserwolf.bubblesort;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalysisLogger 
{   
    private static AnalysisLogger instance;
    private Logger logger;
    
    private AnalysisLogger() throws IOException
    {
        this.logger = Logger.getLogger("bubbleSortAnalysis");
        FileHandler fileHandler = new FileHandler("./log.txt", true);
        fileHandler.setFormatter(new AnalysisFormatter());
        this.logger.addHandler(fileHandler);
    }
    
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
    
    public void addResult(BubbleSortAnalysis analysis)
    {
        this.logInfo(
                "Number Of Lists:\t\t" + analysis.getNumberOfLists(),
                "Number Of Elements Per List:\t" + analysis.getNumberOfElementsPerList(),
                "Interval:\t\t\t" + analysis.getInterval(),
                "Type:\t\t\t\t" + analysis.getElementClass().getSimpleName(),
                "Expectation:\t\t\t" + analysis.getExpectation(),
                "Avarage:\t\t\t" + analysis.getAverage(),
                "Statistical Spread:\t\t" + analysis.getStatisticalSpread(),
                "Empirical Spread:\t\t" + analysis.getEmpiricalSpread(),
                "ConfidenzInterval 95%:\t\t" + analysis.getConfidenzInterval95()
        );
    }
    
    public void logInfo(String message)
    {
        this.logger.log(Level.INFO, message);
    }
    
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
