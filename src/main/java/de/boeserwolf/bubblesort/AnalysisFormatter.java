package de.boeserwolf.bubblesort;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class AnalysisFormatter extends Formatter
{
    @Override
    public String format(LogRecord record) 
    {
        return record.getMessage() + "\n--------------------------\n";
    }
}
