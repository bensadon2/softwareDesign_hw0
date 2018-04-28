package foo;

import il.ac.technion.cs.sd.confess.ext.SecureDatabase;

public interface IDatabase {

//    public static final SecureDatabase database = new SecureDatabase();

    default void addEntry(byte[] key, byte[] value) {
        SecureDatabase.addEntry(key, value);
    }

    default byte[] get(byte[] key) throws InterruptedException {
        return SecureDatabase.get(key);
    }
}
