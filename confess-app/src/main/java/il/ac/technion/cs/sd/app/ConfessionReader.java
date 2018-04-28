package il.ac.technion.cs.sd.app;

import foo.myDatabase;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * This class will only be instantiated after
 * {@link ConfessionInitializer#setup(java.lang.String) has been called}.
 */
public class ConfessionReader {
    /**
     * Returns the confession associated with the ID, or empty.
     */

    myDatabase db;

    public ConfessionReader() {
        this.db = new myDatabase();
    }

    public ConfessionReader(myDatabase db) {
        this.db = db;
    }

    public Optional<String> getConfession(Integer id) throws InterruptedException {

        try {
            byte[] key = id.toString().getBytes();
            byte[] confession = db.get(key);
            Optional<String> result = Optional.of(new String(confession));
            return result;
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

}
