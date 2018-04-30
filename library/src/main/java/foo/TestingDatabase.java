package foo;

import foo.IDatabase;

public class TestingDatabase {

    //instead of implements, keep an internal instance

    private IDatabase myDb;

    public TestingDatabase(IDatabase db) {
        myDb = db;
    }

    public void addEntry(byte[] key, byte[] value) {
        myDb.addEntry(key, value);
    }

    public byte[] get(byte[] key) throws InterruptedException {
        return myDb.get(key);
    }

}
