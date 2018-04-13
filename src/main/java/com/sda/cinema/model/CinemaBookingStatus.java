package com.sda.cinema.model;

public class CinemaBookingStatus {
    private boolean status;
    private CinemaBookingStatusCode statusCode;

    public CinemaBookingStatus(boolean status, CinemaBookingStatusCode statusCode) {
        this.status = status;
        this.statusCode = statusCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CinemaBookingStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(CinemaBookingStatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
