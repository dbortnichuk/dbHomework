package com.dbortnichuk.db.core;

import com.dbortnichuk.db.model.Record;

/**
 * User: dbortnichuk
 * Date: 2/11/14
 * Time: 2:39 PM
 */
public class RecordConverter implements ConvertableToByteArray<Record> {


    @Override
    public byte[] objectAsByteArray(Record objectToConvert) {
        return ("-n" + objectToConvert.getName() + "-p" + objectToConvert.getPhone()).getBytes();
    }

    @Override
    public Record byteArrayAsObject(byte[] byteArrayToConvert) {
        String input = new String(byteArrayToConvert);
        String name = input.substring(input.indexOf("-n") + 2, input.indexOf("-p"));
        String phone = input.substring(input.indexOf("-p") + 2);
        return new Record(name, phone);
    }
}
