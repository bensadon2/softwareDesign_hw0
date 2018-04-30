import foo.IDatabase;
import foo.TestingDatabase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.mockito.Mockito;

public class BasicLibTests {

    private TestingDatabase testDB;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Test
    public void testAdd() {
        IDatabase mockDB = Mockito.mock(IDatabase.class);
        testDB = new TestingDatabase(mockDB);
        testDB.addEntry("100".getBytes(), "shai".getBytes());
        Mockito.verify(mockDB, Mockito.only()).addEntry("100".getBytes(), "shai".getBytes());

        testDB.addEntry("200".getBytes(), "ran".getBytes());
        testDB.addEntry("300".getBytes(), "jim".getBytes());
        Mockito.verify(mockDB, Mockito.atMost(3)).addEntry(Mockito.any(byte[].class), Mockito.any(byte[].class));
    }
}
