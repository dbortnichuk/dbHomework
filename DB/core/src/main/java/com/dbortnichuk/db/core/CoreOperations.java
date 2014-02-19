package com.dbortnichuk.db.core;

/**
 * User: dbortnichuk
 * Date: 2/9/14
 * Time: 1:56 PM
 */
public interface CoreOperations<K, V> extends Operations{

    public static final String OPERATION_GROUP_CORE = "core";

    V retrieve(K recordKey);

    V create(K key, V recordToStore);

    V update(K key, V recordToUpdate);

    V delete(K key);

}
