package pl.touroperator.touroperator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touroperator.touroperator.model.Reservation;
import pl.touroperator.touroperator.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Reservation save(Reservation reservation);
}
