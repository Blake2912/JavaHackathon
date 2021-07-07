package com.example.applicationtoconnectpeople;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDetailsDao {
    @Insert
    void insert(UserDetails userDetails);

    @Update
    void update(UserDetails userDetails);

    @Query("SELECT * FROM user_details WHERE PhoneNumber LIKE :phone AND Password LIKE :password")
    UserDetails login(String phone,String password);

    @Query("SELECT * FROM user_details WHERE PhoneNumber LIKE :phone AND Password LIKE :password")
    UserDetails findCustomer(String phone,String password);
}
