package il.ac.technion.cs.sd.app;

import foo.MyDatabase;

import java.util.Optional;

/**
 * This class will only be instantiated after
 * {@link ConfessionInitializer#setup(java.lang.String) has been called}.
 */
public class ConfessionReader {
    /**
     * Returns the confession associated with the ID, or empty.
     */

    MyDatabase db;

    public Optional<String> getConfession(Integer id) {
        throw new RuntimeException("Not implemented");
    }

    public ConfessionReader() {
        db = new MyDatabase();
    }

}
