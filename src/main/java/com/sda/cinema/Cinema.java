package com.sda.cinema;

import com.sda.cinema.model.*;

public class Cinema {
    private final CinemaBookingService cinemaBookingService;
    private final CinemaNotifier cinemaNotifier;

    public Cinema(CinemaBookingService cinemaBookingService, CinemaNotifier cinemaNotifier) {
        this.cinemaBookingService = cinemaBookingService;
        this.cinemaNotifier = cinemaNotifier;
    }

    public CinemaBookingResponse bookMovie(CinemaMovie movie, int seating, CinemaUser user, CinemaChannel channel) {
        CinemaBookingStatus status = cinemaBookingService.bookSeating(movie, seating);
        if (!status.isStatus()) {
            CinemaBookingResponse failureResponse = new CinemaBookingResponse();
            switch (status.getStatusCode()) {
                case WRONG_SEATING_ID:
                    failureResponse.setMessage("wybrano niepoprawny numer miejsca");
                    break;
                case SEATING_ALREADY_BOOKED:
                    failureResponse.setMessage("wybrane miejsce jest juz zajete");
                    break;
                case INVALID_SEATING_TYPE:
                    failureResponse.setMessage("zly typ miejsca");
                    break;
            }
            return failureResponse;
        }
        CinemaNotifierResponse response = cinemaNotifier.notify(user, channel, "twoj numer biletu to : XXXYYYZZZ");
        if (!response.isStatus()) {
            CinemaBookingResponse cinemaBookingResponse = new CinemaBookingResponse();
            cinemaBookingResponse.setStatus(false);

            switch (response.getStatusCode()) {

                case SERVER_ERROR:
                    cinemaBookingResponse.setMessage("oops, twoj bilet zostal zarezerwowany ale nie moglismy wyslac ci biletu");
                    break;
                case CHANNEL_NOT_SPECIFIED:
                    cinemaBookingResponse.setMessage("nie moglismy wyslac biletu poniewaz nie wskazales danych adresowych");
                    break;
            }
            return cinemaBookingResponse;
        }
        return new CinemaBookingResponse(true, "miejsce zarezerwowane, za chwile dostaniesz bilet");
    }
}
