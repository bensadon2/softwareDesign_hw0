package il.ac.technion.cs.sd.app;

import foo.myDatabase;

/**
 * This class will be instantiated once per test.
 */
public class ConfessionInitializer {
    /**
     * Saves the csvData persistently, so that it could be read using ConfessionReader.
     * The format of each line of the data is $id,$content.
     */

    myDatabase db;

    public ConfessionInitializer() {
        this.db = new myDatabase();
    }

    public ConfessionInitializer(myDatabase db) {
        this.db = db;
    }

    public void setup(String csvData) {
        String[] pairs = csvData.split("\r?\n");
        for (String confession : pairs) {
            String[] keyValue = confession.split(",");
            db.addEntry(keyValue[0].getBytes(), keyValue[1].getBytes());
        }
    }
}
