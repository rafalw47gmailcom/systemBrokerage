package pl.touroperators.touroperatorr2.methods;

import pl.touroperators.touroperatorr2.model.Reservation;
import pl.touroperators.touroperatorr2.model.ReservationExternal;
import pl.touroperators.touroperatorr2.model.Tour;

import java.time.LocalDate;

public class CopyTool {

    private Tour tour;

    private Reservation reservation;

    public CopyTool(Tour tour, Reservation reservation) {
        this.tour = tour;
        this.reservation = reservation;

    }

    public CopyTool() {
    }



    public static Reservation copyTourData(Reservation reservation, Tour tour){

        reservation.setTitle(reservation.getTitle());
        reservation.setFirstName(reservation.getFirstName());
        reservation.setLastName(reservation.getLastName());
        reservation.setEmail(reservation.getEmail());

        reservation.setTitle(tour.getTitle());
        reservation.setDateFrom(tour.getDateFrom());
        reservation.setDateTo(tour.getDateTo());
        reservation.setPrice(tour.getPrice());
        reservation.setDestinationCity(tour.getDestinationCity());
        reservation.setDepartureFrom(tour.getDepartureFrom());
        reservation.setCountry(tour.getCountry());


        return  reservation;
    }

    public static Reservation copyDataFromExternalReservation(Reservation reservation, ReservationExternal reservationExternal){

        reservation.setTitle(reservationExternal.getTitle());
        reservation.setFirstName(reservationExternal.getFirstName());
        reservation.setLastName(reservationExternal.getLastName());
        reservation.setEmail(reservationExternal.getEmail());
        reservation.setTitle(reservationExternal.getTitle());

        LocalDate dateFrom2 = LocalDate.parse(reservationExternal.getDateFrom());
        LocalDate dateTo2 = LocalDate.parse(reservationExternal.getDateTo());
        reservation.setDateFrom(dateFrom2);
        reservation.setDateTo(dateTo2);

        reservation.setPrice(reservationExternal.getPrice());
        reservation.setDestinationCity(reservationExternal.getDestinationCity());
        reservation.setDepartureFrom(reservationExternal.getDepartureFrom());
        reservation.setCountry(reservationExternal.getCountry());


        return  reservation;
    }



}
