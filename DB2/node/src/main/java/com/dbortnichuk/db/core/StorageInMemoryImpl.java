package com.dbortnichuk.db.core;

import java.util.HashMap;
import java.util.Map;

/**
 * User: dbortnichuk
 * Date: 2/9/14
 * Time: 2:23 PM
 */
public class StorageInMemoryImpl implements MapBasedStorage<String, byte[]> {

    private Map<String, byte[]> dataContainer;

    public StorageInMemoryImpl() {
        dataContainer = new HashMap<String, byte[]>();
    }

    @Override
    public Map<String, byte[]> getDataContainer() {
        return dataContainer;
    }

    @Override
    public void setDataContainer(Map<String, byte[]> dataContainer) {
        this.dataContainer = dataContainer;
    }


}

