package il.ac.technion.cs.sd.app;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

  @Rule public Timeout globalTimeout = Timeout.seconds(10);

  private static ConfessionReader setupAndGetReader(String fileName) throws FileNotFoundException {
    String fileContents =
        new Scanner(new File(ExampleTest.class.getResource(fileName).getFile())).useDelimiter("\\Z").next();
    new ConfessionInitializer().setup(fileContents);
    return new ConfessionReader();
  }

  @Test
  public void testSimple() throws Exception {
    ConfessionReader reader = setupAndGetReader("small");
    assertEquals(Optional.of("small confession"), reader.getConfession(123));
  }

  @Test
  public void testEmpty() throws Exception {
    ConfessionReader reader = setupAndGetReader("small");
    assertEquals(Optional.empty(), reader.getConfession(1234));
  }

  @Test
  public void largeTest() throws Exception {
    ConfessionReader reader = setupAndGetReader("large");
    assertEquals(Optional.of("large confession"), reader.getConfession(123));
  }
}
