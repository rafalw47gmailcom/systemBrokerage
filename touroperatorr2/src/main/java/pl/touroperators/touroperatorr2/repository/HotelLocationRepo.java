package pl.touroperators.touroperatorr2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touroperators.touroperatorr2.model.HotelLocation;

@Repository
public interface HotelLocationRepo extends JpaRepository<HotelLocation, Long> {
}
