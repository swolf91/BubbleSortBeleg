package de.boeserwolf.bubblesort;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class AnalysisFormatter extends Formatter
{
    /*
     * Gibt das Format an, mitdem der Datenlogger, die Daten in die Datei schreibt
     */
    @Override
    public String format(LogRecord record) 
    {
        return record.getMessage() + "\n--------------------------\n";
    }
}
