package com.example.travelagencyproject.models.dtos;

import java.util.Date;

public class UpdateHolidayDTO {
    private long id;

    private long location;

    private String title;

    private Date startDate;

    private int duration;

    private String  price;

    private int freeSlots;

    public UpdateHolidayDTO(long id, long location, String title, Date startDate, int duration, String price, int freeSlots) {
        setId(id);
        setLocation(location);
        setTitle(title);
        setStartDate(startDate);
        setDuration(duration);
        setPrice(price);
        setFreeSlots(freeSlots);
    }

    public UpdateHolidayDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long location) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(int freeSlots) {
        this.freeSlots = freeSlots;
    }
}
