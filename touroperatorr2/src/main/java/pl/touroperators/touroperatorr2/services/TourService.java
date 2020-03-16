package pl.touroperators.touroperatorr2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.touroperators.touroperatorr2.model.Tour;
import pl.touroperators.touroperatorr2.repository.TourRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TourService {

    protected static final Logger log = Logger.getLogger(String.valueOf(TourService.class));

    private TourRepo tourRepo;

    @Autowired
    public TourService(TourRepo tourRepo) {
        this.tourRepo = tourRepo;
    }

    public Iterable<Tour> findAll(){
     //   log.info("Start downloading tour offers");
        return tourRepo.findAll();
    }


    public List<Tour> findAllByCountryAndDestinationCityAndDateFromAndDateTo( String country,String destinationCity,LocalDate dateFrom,LocalDate dateTo){
        return tourRepo.findAllByCountryAndDestinationCityAndDateFromAndDateTo(country,destinationCity, dateFrom, dateTo);
    }

    public Optional<Tour> findById(Long id){
        return tourRepo.findById(id);
    }

    public Tour getById(Long id){
        return tourRepo.getOne(id);
    }

    public void deleteById(long id){
        tourRepo.deleteById(id);
    }

    public Tour save(Tour tour) {
        return tourRepo.save(tour);
    }

    public int sendNumberOfOffers() {
        return tourRepo.findAll().size();
    }

    public List<Tour> findAllAsList(){
        return tourRepo.findAll();
          }

    public Iterable<Tour> findAllByCountry(String country){
        return tourRepo.findAllByCountry(country);
    }

    public Iterable<Tour> findAllByPrice(int price) {
        return tourRepo.findAllByPrice(price);
    }

    public Iterable<Tour> findAllByDestinationCity(String destinationCity) {
        return tourRepo.findAllByDestinationCity(destinationCity);
    }


    public Iterable<Tour> findAllByTitle(String title) {
        return tourRepo.findAllByTitle(title);
    }

    public Iterable<Tour> findAllByDepartureFrom(String destinationCity) {
        return tourRepo.findAllByDepartureFrom(destinationCity);
    }

    public List<Tour> findAllByTitleLike(String title){
        return tourRepo.findAllByTitleLike(title);
    };

    public List<Tour> findAllByCountryLike(String country) {
        return tourRepo.findAllByCountryLike(country);
    }

    public List<Tour> findAllByDestinationCityLike(String destinationCity){
        return tourRepo.findAllByDestinationCityLike(destinationCity);
    };

    public List<Tour> findAllByDateFromLike(LocalDate dateFrom){
        return tourRepo.findAllByDateFromLike(dateFrom);
    };

    public List<Tour> findAllByDateToLike(LocalDate dateTo){
        return tourRepo.findAllByDateToLike(dateTo);
    };

    public List<Tour> findAllByPriceLike(int price){
        return tourRepo.findAllByPriceLike(price);
    };


/*
    public Iterable<Tour> findAllByCountryAndAndDateFromAndAndDateTo(String country, LocalDate dateFrom, LocalDate dateTo) {
        return tourRepo.findAllByCountryAndAndDateFromAndAndDateTo(country,dateFrom,dateTo);
    }
    Iterable<Tour> findAllByPriceAndAndDateFromAndAndDateTo(String price, String dateFrom, String dateTo) {
        return null;
    }
    Iterable<Tour> findAllByTitleAndAndDateFromAndAndDateTo(String title, String dateFrom, String dateTo) {
        return null;
    }
    Iterable<Tour> findAllByDestinationCityAndAndDateFromAndAndDateTo(String DestinationCity, String dateFrom, String dateTo) {
        return null;
    }
    Iterable<Tour> findAllByDepartureFromAndAndDateFromAndAndDateTo(String cDepartureFrom, String dateFrom, String dateTo) {
        return null;
    }
 */
}
