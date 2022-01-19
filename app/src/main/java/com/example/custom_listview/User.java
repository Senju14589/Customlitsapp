package com.example.custom_listview;

public class User {

    String name, lastMessage, lastMsgTime, phone, country;
    int imageId;

    public User(String name, String lastMessage, String lastMsgTime, String phoneNo, String country, int imageId) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.lastMsgTime = lastMsgTime;
        this.phone = phone;
        this.country = country;
        this.imageId = imageId;
    }
}
