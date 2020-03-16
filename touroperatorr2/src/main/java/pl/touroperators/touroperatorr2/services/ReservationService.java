package pl.touroperators.touroperatorr2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.touroperators.touroperatorr2.model.Reservation;
import pl.touroperators.touroperatorr2.repository.ReservationRepo;

import java.util.List;

@Service
public class ReservationService {

    private ReservationRepo reservationRepo;

    @Autowired
    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public List<Reservation> findAll(){
        return reservationRepo.findAll();
    };

    public Reservation save(Reservation reservation) {

        return reservationRepo.save(reservation);
    }



    // public Iterable<Reservation> findAll(){
       // return reservationRepo.findAll();
 //   }





}
