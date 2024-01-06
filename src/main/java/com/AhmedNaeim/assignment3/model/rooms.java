package com.AhmedNaeim.assignment3.model;

public class rooms {

    private int price;
    private long RoomID;
    private String roomType;
    private Boolean availability;

    public rooms() {
    }

    public rooms(long RoomID, String roomType, int price, Boolean availability) {
        this.RoomID = RoomID;
        this.roomType = roomType;
        this.price = price;
        this.availability = availability;
    }

    public long getRoomID() {
        return this.RoomID;
    }

    public Boolean getAvailability() {
        return this.availability;
    }

    public void setRoomID(long roomID) {
        this.RoomID = roomID;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }


    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


