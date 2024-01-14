package com.example.travelagencyproject.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "holidays")
public class Holiday {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @ManyToOne
        @JoinColumn(name = "location")
        private Location location;

        @Column(name = "title")
        private String title;

        @Column(name = "startDate")
        private Date startDate;

        @Column(name = "duration")
        private int duration;

        @Column(name = "price")
        private String price;

        @Column(name = "freeSlots")
        private int freeSlots;


    public Holiday() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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
