package com.navin.digishop.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BasketDao {



    @Insert
    long insert(Basket basket);

    @Query("select * from basket")
    public List<Basket> getBasketList();

    @Delete
    void delete(Basket basket);

    @Update
    void update(Basket basket);

}
