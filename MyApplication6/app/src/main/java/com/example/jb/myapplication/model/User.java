package com.example.jb.myapplication.model;

public class User {
    private String id;
    public int photo;
    public String name;

    public User(String id, int photo, String name) {
        this.id = id;
        this.photo = photo;
        this.name = name;
    }

    public User(int photo, String name) {
        this.photo = photo;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public User(int photo) {
        this.photo = photo;
    }

    public User() {
    }

    public User(String id, String name) {
        super();
        this.id=id;
        this.name=name;
    }

    public User(String id, int photo) {
        super();
        this.id = id;
        this.photo = photo;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }
}