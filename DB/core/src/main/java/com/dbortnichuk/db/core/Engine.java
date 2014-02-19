package com.dbortnichuk.db.core;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dbortnichuk
 * Date: 2/9/14
 * Time: 2:52 PM
 */
public class Engine {

    MapBasedStorage mapBasedStorage;
    List<Operations> enabledOperationGroups;

    public Engine() {
        mapBasedStorage = new StorageInMemoryImpl();
    }

    public MapBasedStorage getMapBasedStorage() {
        return mapBasedStorage;
    }

    public void operationCallback(Operations operationGroup) {
        if (enabledOperationGroups==null) {
            enabledOperationGroups = new ArrayList<Operations>();
        }
        enabledOperationGroups.add(operationGroup);
    }

    public Operations getOperationGroup(String operationGroupName) {
        for (Operations operationGroup : enabledOperationGroups) {
            if (operationGroup.getOperationsGroupName().equals(operationGroupName)) {
                return operationGroup;
            }
        }
        return null;
    }

}
