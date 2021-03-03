package com.something.smssender;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EmergencyContact")
public class EmergencyContact {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String contact_number;
}
