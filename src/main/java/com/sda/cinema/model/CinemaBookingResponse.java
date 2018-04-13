package com.sda.cinema.model;

public class CinemaBookingResponse {
    private boolean status;
    private String message;

    public CinemaBookingResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public CinemaBookingResponse() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
