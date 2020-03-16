package pl.touroperator.touroperator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.touroperator.touroperator.model.User;
import pl.touroperator.touroperator.repository.UserRepo;

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
