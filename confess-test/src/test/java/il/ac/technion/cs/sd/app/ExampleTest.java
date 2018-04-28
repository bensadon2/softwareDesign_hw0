package il.ac.technion.cs.sd.app;

import foo.myDatabase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

public class ExampleTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Mock
    myDatabase mockDb;

    Map<String, byte[]> mockMap = new HashMap<>();

    @Before
    public void testSetup() throws Exception {

        MockitoAnnotations.initMocks(this);
        mockMap.clear();

        Mockito.doAnswer(invocation -> {
            byte[] key = invocation.getArgument(0);
            String strKey = new String(key);
            byte[] value = invocation.getArgument(1);
            mockMap.put(strKey, value);
            return null;
        }).when(mockDb).addEntry(any(byte[].class), any(byte[].class));

        when(mockDb.get(any(byte[].class))).then(arg -> {
            byte[] key = arg.getArgument(0);
            String strKey = new String(key);
            if (mockMap.containsKey(strKey)) {
                return mockMap.get(strKey);
            }
            throw new NoSuchElementException();
        });
    }


    private /*static*/ ConfessionReader setupAndGetReader(String fileName) throws FileNotFoundException {
        String fileContents =
                new Scanner(new File(ExampleTest.class.getResource(fileName).getFile())).useDelimiter("\\Z").next();
        ConfessionInitializer CI = new ConfessionInitializer(mockDb);
        CI.setup(fileContents);
        return new ConfessionReader(mockDb);
    }

    @Test
    public void testSimple() throws Exception {
        ConfessionReader reader = setupAndGetReader("small");
        assertEquals(Optional.of("small confession"), reader.getConfession(123));
    }

    //
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
