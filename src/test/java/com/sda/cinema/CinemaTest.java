package com.sda.cinema;

import com.sda.cinema.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CinemaTest {

    @Test
    public void userCanReserveMovieAndReceiveNotificationWithTicket() {
        //given - mockowania, definicje stabow,
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(true, null));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.any()))
                .then(e -> new CinemaNotifierResponse(true, null));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);
        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 12, null, null);

        //then
        Assert.assertEquals("miejsce zarezerwowane, za chwile dostaniesz bilet", response.getMessage());
        Assert.assertTrue(response.isStatus());
        //CZY NA RZECZ MOCKA PRZYNAJMNIEJ RAZ ZOSTALA WYKONANANA METODA NOTIFY Z DOWOLNYMI PARAMETRAMI
        Mockito.verify(cinemaNotifier, Mockito.timeout(1)).notify(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void userCannotReserveMovieBecauseSelectedSeatingIsInvalid() {
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(false, CinemaBookingStatusCode.WRONG_SEATING_ID));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.any()))
                .then(e -> new CinemaNotifierResponse(true, null));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);
        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 12, null, null);

        //then
        Assert.assertEquals("wybrano niepoprawny numer miejsca", response.getMessage());
        Assert.assertFalse(response.isStatus());
//        Mockito.verify(cinemaNotifier, Mockito.timeout(0)).notify(Mockito.any(), Mockito.any(), Mockito.any());

    }

    @Test
    public void userCannotBookMovieBecauseSelectedSeatIsAlreadyTaken() {
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(false, CinemaBookingStatusCode.SEATING_ALREADY_BOOKED));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.any()))
                .then(e -> new CinemaNotifierResponse(true, null));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 11, null, null);

        //then
        Assert.assertEquals(response.getMessage(), "wybrane miejsce jest juz zajete");
        Assert.assertFalse(response.isStatus());
//        Mockito.verify(cinemaNotifier, Mockito.timeout(0)).notify(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    public void shouldReturnServerErrorMessageWhenThereIsServerErrorInNotifier() {
        //given
        CinemaBookingService bookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(bookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(true, null));
        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.anyString()))
                .then(e -> new CinemaNotifierResponse(false, CinemaNotifierResponseStatus.SERVER_ERROR));

        Cinema cinema = new Cinema(bookingService, cinemaNotifier);

        //when
        CinemaBookingResponse cinemaBookingResponse = cinema.bookMovie(null, 0, null, null);

        //then
        Assert.assertFalse(cinemaBookingResponse.isStatus());
        Assert.assertEquals("oops, twoj bilet zostal zarezerwowany ale nie moglismy wyslac ci biletu", cinemaBookingResponse.getMessage());
    }
    @Test
    public void shouldReturnChannelNotSpecifiedMessageWhenThereIsChannelNotSpecifiedInNotifier() {
        //given
        CinemaBookingService bookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(bookingService.bookSeating(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(true, null));
        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.anyString()))
                .then(e -> new CinemaNotifierResponse(false, CinemaNotifierResponseStatus.CHANNEL_NOT_SPECIFIED));

        Cinema cinema = new Cinema(bookingService, cinemaNotifier);

        //when
        CinemaBookingResponse cinemaBookingResponse = cinema.bookMovie(null, 0, null, null);

        //then
        Assert.assertFalse(cinemaBookingResponse.isStatus());
        Assert.assertEquals("nie moglismy wyslac biletu poniewaz nie wskazales danych adresowych", cinemaBookingResponse.getMessage());
    }
}

