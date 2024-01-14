package com.example.travelagencyproject.models.dtos.responses;

public class ResponseReservationDTO {
    private long id;
    private String contactName;

    private String phoneNumber;

    private ResponseHolidayDTO holiday;

//    public ResponseReservationDTO(long id, String contactName, String phoneNumber, ResponseHolidayDTO holiday) {
//        setId(id);
//        setContactName(contactName);
//        setPhoneNumber(phoneNumber);
//        setHoliday(holiday);
//    }

    public ResponseReservationDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHoliday(ResponseHolidayDTO holiday) {
        this.holiday = holiday;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
