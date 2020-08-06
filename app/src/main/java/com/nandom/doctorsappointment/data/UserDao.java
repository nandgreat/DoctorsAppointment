package com.nandom.doctorsappointment.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users WHERE email=:email AND password=:password")
    User loginUser(String email, String password);

    @Insert
    void signupUser(User user);

    @Query("SELECT * FROM users WHERE email=:email")
    User getUser(String email);

}
