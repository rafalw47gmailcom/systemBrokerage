package pl.touroperators.touroperatorr2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touroperators.touroperatorr2.model.Reservation;
import pl.touroperators.touroperatorr2.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Reservation save(Reservation reservation);
}
