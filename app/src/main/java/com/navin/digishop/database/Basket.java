package com.navin.digishop.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "basket")
public class Basket {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "productId")
    private int productId;

    @ColumnInfo(name = "title")

    private String title;




    public Basket(int productId, String title) {
        this.setProductId(productId);
        this.setTitle(title);
    }

    @Ignore
    public Basket(int id, int productId, String title) {
        this.setId(id);
        this.setProductId(productId);
        this.setTitle(title);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
