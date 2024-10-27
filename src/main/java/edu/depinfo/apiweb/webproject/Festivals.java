package edu.depinfo.apiweb.webproject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Festivals {

    private Festival[] results = new Festival[1];
    private int size = 0;

    public Festival[] getResults() {
        return results;
    }

    public void add(Festival festival) {
        // Check if the array is full
        if (size == results.length) {
            // If it is, create a new array with double the capacity
            Festival[] newResults = new Festival[results.length + 1];
            // Copy elements from the old array to the new one
            System.arraycopy(results, 0, newResults, 0, results.length);
            // Update reference to the new array
            results = newResults;
        }
        // Add the new festival
        results[size] = festival;
        size++;
    }
}
