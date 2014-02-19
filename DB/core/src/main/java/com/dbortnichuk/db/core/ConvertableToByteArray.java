package com.dbortnichuk.db.core;

/**
 * User: dbortnichuk
 * Date: 2/11/14
 * Time: 2:03 PM
 */
public interface ConvertableToByteArray<T> {

    byte[] objectAsByteArray(T objectToConvert);

    T byteArrayAsObject(byte[] byteArrayToConvert);

}
