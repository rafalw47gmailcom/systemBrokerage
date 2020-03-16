package pl.touroperators.touroperatorr2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.touroperators.touroperatorr2.model.HotelLocation;
import pl.touroperators.touroperatorr2.repository.HotelLocationRepo;

import java.util.List;
import java.util.Optional;

@Service
public class HotelLocationService {

    private HotelLocationRepo hotelLocationRepo;

    @Autowired
    public HotelLocationService(HotelLocationRepo hotelLocationRepo) {
        this.hotelLocationRepo = hotelLocationRepo;
    }

    public Iterable<HotelLocation> findAll(){
        //   log.info("Start downloading tour offers");
        return hotelLocationRepo.findAll();
    }

    public Optional<HotelLocation> findById(Long id){
        return hotelLocationRepo.findById(id);
    }

    public HotelLocation getById(Long id){
        return hotelLocationRepo.getOne(id);
    }

    public void deleteById(long id){
        hotelLocationRepo.deleteById(id);
    }

    public HotelLocation save(HotelLocation hotelLocation) {
        return hotelLocationRepo.save(hotelLocation);
    }

    public int sendNumberOfOffers() {
        return hotelLocationRepo.findAll().size();
    }

    public List<HotelLocation> findAllAsList(){
        return hotelLocationRepo.findAll();
    }


}
