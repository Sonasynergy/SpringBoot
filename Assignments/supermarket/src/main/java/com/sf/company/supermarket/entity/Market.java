package com.sf.company.supermarket.entity;


import javax.persistence.*;

@Entity
@Table(name="market")
public class Market {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name="market_sequence", sequenceName = "market_sequence", allocationSize=1)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String storeName;

    @Column(name="address")
    private String address;

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name="store_id")
    private StoreOwner storeOwner;

    public Market() {
    }

    public Market(int id, String storeName, String address) {
        this.id = id;
        this.storeName = storeName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StoreOwner getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(StoreOwner storeOwner) {
        this.storeOwner = storeOwner;
    }

    @Override
    public String toString() {
        return "Market{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", address='" + address + '\'' +
                ", storeOwner=" + storeOwner +
                '}';
    }


//    @Override
//    public String toString() {
//        return "Market{" +
//                "id=" + id +
//                ", storeName='" + storeName + '\'' +
//                ", address='" + address + '\'' +
//                '}';
//    }
}
