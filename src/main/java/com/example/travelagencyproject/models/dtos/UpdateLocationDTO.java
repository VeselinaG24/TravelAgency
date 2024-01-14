package com.example.travelagencyproject.models.dtos;
public class UpdateLocationDTO {
    private long id;

    private String street;

    private String number;

    private String city;

    private String country;

    private String  imageUrl;

    public UpdateLocationDTO(long id, String street, String number, String city, String country, String imageUrl) {
        setId(id);
        setStreet(street);
        setNumber(number);
        setCity(city);
        setCountry(country);
        setImageUrl(imageUrl);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}