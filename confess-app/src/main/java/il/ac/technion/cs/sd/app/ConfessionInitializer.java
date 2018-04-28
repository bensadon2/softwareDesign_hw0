package il.ac.technion.cs.sd.app;

import java.util.HashMap;
import java.util.Map;

/**
 * This class will be instantiated once per test.
 */
public class ConfessionInitializer {
    /**
     * Saves the csvData persistently, so that it could be read using ConfessionReader.
     * The format of each line of the data is $id,$content.
     */
    Map<Integer, String> myConfessions = new HashMap<>();

    public void setup(String csvData) {
//        String[] pairs = csvData.split()
//        throw new UnsupportedOperationException("Not implemented");
    }
}
