package pl.touroperator.touroperator.methods;


import pl.touroperator.touroperator.model.Reservation;
import pl.touroperator.touroperator.model.Tour;

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



}
