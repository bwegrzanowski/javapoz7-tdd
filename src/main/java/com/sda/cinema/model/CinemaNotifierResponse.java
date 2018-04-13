package com.sda.cinema.model;

public class CinemaNotifierResponse {
    private boolean status;
    private CinemaNotifierResponseStatus statusCode;

    public CinemaNotifierResponse(boolean status, CinemaNotifierResponseStatus statusCode) {
        this.status = status;
        this.statusCode = statusCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CinemaNotifierResponseStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(CinemaNotifierResponseStatus statusCode) {
        this.statusCode = statusCode;
    }
}
