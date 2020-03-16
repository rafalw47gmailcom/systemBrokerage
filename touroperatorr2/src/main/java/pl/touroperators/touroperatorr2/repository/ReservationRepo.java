package pl.touroperators.touroperatorr2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touroperators.touroperatorr2.model.Reservation;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {

    List<Reservation> findAll();

}
