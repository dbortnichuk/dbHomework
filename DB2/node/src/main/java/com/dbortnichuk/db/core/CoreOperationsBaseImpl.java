package com.dbortnichuk.db.core;

/**
 * User: dbortnichuk
 * Date: 2/9/14
 * Time: 2:06 PM
 */
public class CoreOperationsBaseImpl implements CoreOperations<String, byte[]> {

    Engine engine;

    public CoreOperationsBaseImpl(Engine engine) {
        this.engine = engine;
    }

    @Override
    public byte[] retrieve(String recordKey) {
        return (byte[]) engine.getMapBasedStorage().getDataContainer().get(recordKey);
    }

    @Override
    public byte[] create(String key, byte[] recordToStore) {
        return (byte[]) engine.getMapBasedStorage().getDataContainer().put(key, recordToStore);
    }

    @Override
    public byte[] update(String key, byte[] recordToUpdate) {
        return (byte[]) engine.getMapBasedStorage().getDataContainer().put(key, recordToUpdate);
    }

    @Override
    public byte[] delete(String key) {
        return (byte[]) engine.getMapBasedStorage().getDataContainer().remove(key);
    }

    @Override
    public String getOperationsGroupName() {
        return OPERATION_GROUP_CORE;
    }
}
