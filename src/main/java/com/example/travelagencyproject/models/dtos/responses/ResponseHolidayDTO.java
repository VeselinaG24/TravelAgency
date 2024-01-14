package com.example.travelagencyproject.models.dtos.responses;

import java.util.Date;

public class ResponseHolidayDTO {
    private long id;

    private ResponseLocationDTO location;

    private String title;

    private Date startDate;

    private int duration;

    private double  price;

    private int freeSlots;

//    public ResponseHolidayDTO(long id, ResponseLocationDTO location, String title, Date startDate, int duration, double price, int freeSlots) {
//        setId(id);
//        setLocation(location);
//        setTitle(title);
//        setStartDate(startDate);
//        setDuration(duration);
//        setPrice(price);
//        setFreeSlots(freeSlots);
//    }

    public ResponseHolidayDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResponseLocationDTO getLocation() {
        return location;
    }

    public void setLocation(ResponseLocationDTO location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(int freeSlots) {
        this.freeSlots = freeSlots;
    }
}
