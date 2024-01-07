package com.AhmedNaeim.assignment3.model;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class book {

    private long roomID;
    private long customerID;
    private Date checkInDate;
    private Date checkOutDate;


    public book(Date checkInDate, long roomID, Date checkOutDate, long customerID) {
        this.checkInDate = checkInDate;
        this.roomID = roomID;
        this.checkOutDate = checkOutDate;
        this.customerID = customerID;
    }


    public Date getCheckOutDate() {
        return this.checkOutDate;
    }


    public Date getCheckInDate() {
        return this.checkInDate;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public long getCustomerID() {
        return this.customerID;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }


    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    public @NotNull long getRoomID() {
        return roomID;
    }

    public void setRoomID(int rooms) {
        this.roomID = rooms;
    }
}


