package com.dbortnichuk.db.model;

import com.dbortnichuk.db.core.ConvertableToByteArray;

/**
 * User: dbortnichuk
 * Date: 2/9/14
 * Time: 3:06 PM
 */
public class Record {

    private String name;
    private String phone;

    public Record(){

    }

    public Record(String aName, String aPhone){
        name = aName;
        phone = aPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
