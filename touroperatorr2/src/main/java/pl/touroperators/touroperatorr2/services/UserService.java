package pl.touroperators.touroperatorr2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.touroperators.touroperatorr2.model.User;
import pl.touroperators.touroperatorr2.repository.UserRepo;

@Service
public class UserService{

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User save(User reservation) {
        return userRepo.save(reservation);
    }




}
