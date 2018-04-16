package il.ac.technion.cs.sd.app;

import java.util.Optional;

/**
 * This class will only be instantiated after
 * {@link ConfessionInitializer#setup(java.lang.String) has been called}.
 */
public class ConfessionReader {
  /** Returns the confession associated with the ID, or empty. */
  public Optional<String> getConfession(Integer id) {
    throw new RuntimeException("Not implemented");
  }
}
