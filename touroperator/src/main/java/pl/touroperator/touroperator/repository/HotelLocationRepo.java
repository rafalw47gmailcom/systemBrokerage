package pl.touroperator.touroperator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touroperator.touroperator.model.HotelLocation;


@Repository
public interface HotelLocationRepo extends JpaRepository<HotelLocation, Long> {
}
