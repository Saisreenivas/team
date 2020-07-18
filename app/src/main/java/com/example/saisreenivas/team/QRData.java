package com.example.saisreenivas.team;

/**
 * Created by Sai sreenivas on 10/13/2016.
 */

public class QRData {
    private int id;
    private String name;
    private String address;
    public QRData()
    {
    }
    public QRData(int id,String name,String address)
    {
        this.id=id;
        this.name=name;
        this.address=address;
    }

    public QRData(String name, String s) {
        this.name=name;
        this.address=s;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
}