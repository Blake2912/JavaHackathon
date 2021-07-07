package com.example.applicationtoconnectpeople;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_details")
public class UserDetails {
    @PrimaryKey(autoGenerate = true)
    Integer uid;
    @ColumnInfo(name="Name")
    String name;
    @ColumnInfo(name="PhoneNumber")
    String phone_number;
    @ColumnInfo(name="Password")
    String password;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
