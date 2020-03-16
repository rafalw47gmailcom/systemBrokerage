package pl.touroperators.touroperatorr2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.touroperators.touroperatorr2.model.Hotel;
import pl.touroperators.touroperatorr2.repository.HotelRepo;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private HotelRepo hotelRepo;

    @Autowired
    public HotelService(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    public Iterable<Hotel> findAll(){
        //   log.info("Start downloading tour offers");
        return hotelRepo.findAll();
    }

    public Optional<Hotel> findById(Long id){
        return hotelRepo.findById(id);
    }

    public Hotel getById(Long id){
        return hotelRepo.getOne(id);
    }

    public void deleteById(long id){
        hotelRepo.deleteById(id);
    }

    public Hotel save(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    public int sendNumberOfOffers() {
        return hotelRepo.findAll().size();
    }

    public List<Hotel> findAllAsList(){
        return hotelRepo.findAll();
    }

}
