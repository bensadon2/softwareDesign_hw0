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

    MyDatabase db = new MyDatabase();

    public Optional<String> getConfession(Integer id) {

        try {
            byte[] confession = db.get(id.toString().getBytes());
            Optional<String> result = Optional.of(new String(confession));
            return result;
        } catch (InterruptedException e) {
            return Optional.empty();
        }
    }

}
