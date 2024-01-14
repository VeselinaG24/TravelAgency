package com.example.travelagencyproject.models.dtos;

public class CreateReservationDTO {
    private String contactName;

    private String phoneNumber;

    private Long holiday;

    public CreateReservationDTO(String contactName, String phoneNumber, Long holiday) {
        setContactName(contactName);
        setPhoneNumber(phoneNumber);
        setHoliday(holiday);
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

    public Long getHoliday() {
        return holiday;
    }

    public void setHoliday(Long holiday) {
        this.holiday = holiday;
    }
}
