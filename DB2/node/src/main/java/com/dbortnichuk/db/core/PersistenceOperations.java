package com.dbortnichuk.db.core;

/**
 * User: dbortnichuk
 * Date: 2/9/14
 * Time: 2:12 PM
 */
public interface PersistenceOperations extends Operations {

    public static final String OPERATION_GROUP_PERSISTENCE = "persistence";
    public static final String PATH_PERSISTENT_STORAGE_DEFAULT = "/data/data.dat";

    public void write();

    public Object read();

}
