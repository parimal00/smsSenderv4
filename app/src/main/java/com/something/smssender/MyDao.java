package com.something.smssender;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public  void addContactNumber(EmergencyContact emergencyContact);

    @Query("select * from EmergencyContact")
    public List<EmergencyContact> getEmergencyContact();

    @Delete
    public  void  deleteUser(EmergencyContact emergencyContact);
}
