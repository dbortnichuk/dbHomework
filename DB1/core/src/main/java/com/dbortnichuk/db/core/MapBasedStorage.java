package com.dbortnichuk.db.core;

import java.io.Serializable;
import java.util.Map;

/**
 * User: dbortnichuk
 * Date: 2/9/14
 * Time: 2:22 PM
 */
public interface MapBasedStorage<K, V> extends Storage, Serializable {

    Map<K, V> getDataContainer();

    void setDataContainer(Map<K, V> dataContainer);

}
