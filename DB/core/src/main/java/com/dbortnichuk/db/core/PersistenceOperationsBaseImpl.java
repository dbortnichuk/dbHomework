package com.dbortnichuk.db.core;

import java.io.*;

/**
 * User: dbortnichuk
 * Date: 2/9/14
 * Time: 2:47 PM
 */
public class PersistenceOperationsBaseImpl implements PersistenceOperations {

    Engine engine;

    public PersistenceOperationsBaseImpl(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void write() {
        File persistentStorage = new File(getPersistenceStoragePath());
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(persistentStorage)));
            outputStream.writeObject(engine.getMapBasedStorage().getDataContainer());
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object read() {
        File persistentStorageDirectory = new File(getPersistenceStoragePath());
        ObjectInputStream inputStream = null;
        Object persistentStorage = null;
        try {
            inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(persistentStorageDirectory)));
            persistentStorage = inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return persistentStorage;
    }

    private String getPersistenceStoragePath() {
        return new File(System.getProperty("user.dir")).getParent()
                + PATH_PERSISTENT_STORAGE_DEFAULT;
    }

    @Override
    public String getOperationsGroupName() {
        return OPERATION_GROUP_PERSISTENCE;
    }
}
