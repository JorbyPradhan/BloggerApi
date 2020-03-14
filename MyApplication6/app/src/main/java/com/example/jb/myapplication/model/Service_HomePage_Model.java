package com.example.jb.myapplication.model;

/**
 * Created by UCSM on 10/24/2016.
 */

public class Service_HomePage_Model {
    public int item;
    public String Name;

    public Service_HomePage_Model(String Name) {
        this.Name = Name;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Service_HomePage_Model(int item) {
        this.item = item;
    }
}
