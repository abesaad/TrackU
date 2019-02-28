package com.uninorte.edu.co.tracku.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public int userId;

    @ColumnInfo(name="email")
    public String email;

    @ColumnInfo(name="password_hash")
    public String passwordHash;
}
