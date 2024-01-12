package com.ahmednaeim.demo3.model;

import java.util.Date;

public class bookings {

    private rooms room;
    private users customer;
    private long bookingID;
    private Date checkInDate;
    private Date checkOutDate;


    public bookings(long bookingID, Date checkInDate, rooms room, Date checkOutDate, users customer) {
        this.bookingID = bookingID;
        this.checkInDate = checkInDate;
        this.room = room;
        this.checkOutDate = checkOutDate;
        this.customer = customer;
    }

    public long getBookingID() {
        return this.bookingID;
    }

    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    public Date getCheckInDate() {
        return this.checkInDate;
    }

    public void setCustomer(users customer) {
        this.customer = customer;
    }

    public users getCustomer() {
        return this.customer;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }


    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    public rooms getRoom() {
        return room;
    }

    public void setRoom(rooms rooms) {
        this.room = rooms;
    }
}
