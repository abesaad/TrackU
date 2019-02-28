package com.uninorte.edu.co.tracku.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.uninorte.edu.co.tracku.database.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from user")
    List<User> getAllUsers();


    @Query("select * from user where userId=:id")
    List<User> getUserById(int id);

    @Query("select * from user where email=:email")
    List<User> getUserByEmail(String  email);

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

}
