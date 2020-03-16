package pl.touroperator.touroperator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touroperator.touroperator.model.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long> {
}
