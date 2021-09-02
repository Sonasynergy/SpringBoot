package com.sf.company.supermarket.entity;

import javax.persistence.*;

@Entity
@Table(name="store_owner")
public class StoreOwner {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name="storeOwner_sequence", sequenceName = "storeOwner_sequence",allocationSize=1)
    @Column(name="store_id")
    private int storeId;

    @Column(name="owner")
    private String storeOwner;

    public StoreOwner() {
    }

    public StoreOwner(int storeId, String storeOwner) {
        this.storeId = storeId;
        this.storeOwner = storeOwner;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    @Override
    public String toString() {
        return "StoreOwner{" +
                "storeId='" + storeId + '\'' +
                ", storeOwner='" + storeOwner + '\'' +
                '}';
    }
}

