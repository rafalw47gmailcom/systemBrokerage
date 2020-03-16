package pl.touroperator.touroperator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touroperator.touroperator.model.UserProfile;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {
}
