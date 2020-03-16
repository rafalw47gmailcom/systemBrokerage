package pl.touroperator.touroperator.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.touroperator.touroperator.model.Tour;
import pl.touroperator.touroperator.services.TourService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TourResource {

    private TourService tourService;

    @Autowired
    public TourResource(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tours/all")
    public ResponseEntity<Iterable<Tour>> findAll(){
        return ResponseEntity.ok(tourService.findAll());
    }

    @GetMapping("/tours/allAsList")
    public ResponseEntity<List<Tour>> findAllAsList(){
        return ResponseEntity.ok(tourService.findAllAsList());
    }

    @GetMapping("tours/all/2")
    public Iterable<Tour> findAll2()
    {
        return tourService.findAll();
    }

    @GetMapping("/tours")
    public Optional<Tour> findById(@RequestParam Long id){
        return tourService.findById(id);
    }

    @GetMapping("/numbers")
    public int sendNumberOfOffers() {
        return tourService.sendNumberOfOffers();
    }

    @GetMapping("/params")
    public List<Tour> findAllByCountryAndDestinationCityAndDateFromAndDateTo(@RequestParam(defaultValue = "") String country,
                                   @RequestParam(defaultValue = "") String destinationCity,
                                   @RequestParam(defaultValue = "") String dateFrom,
                                   @RequestParam(defaultValue = "") String dateTo){

        LocalDate dateFrom2 = LocalDate.parse(dateFrom);
        LocalDate dateTo2 = LocalDate.parse(dateTo);

        return tourService.findAllByCountryAndDestinationCityAndDateFromAndDateTo(country,destinationCity, dateFrom2, dateTo2);
    }










    /*
    @GetMapping("/tours/search")
    public ResponseEntity<Iterable<Tour>> findAllByCountry(RequestParam String country){
        return ResponseEntity.ok(tourService.findAllByCountry(country));}
    @GetMapping("/tours/search")
    public ResponseEntity<List<Tour>> findAllByPrice(@RequestParam int price) {
        return  ResponseEntity.ok(tourService.findAllByPrice(price));}
    @GetMapping("/tours/search")
    public Iterable<Tour> findAllByTitle(@RequestParam String title) {
        return tourService.findAllByTitle(title);}
            @GetMapping("tours/search/byCountryAndDates")
    Iterable<Tour> findAllByCountryAndAndDateFromAndAndDateTo(@RequestParam String country,
                                                              @RequestParam LocalDate dateFrom,
                                                              @RequestParam LocalDate dateTo) {
        return tourService.findAllByCountryAndAndDateFromAndAndDateTo(country,dateFrom,dateTo);
    }
     */
    @GetMapping("/tours/search/byCity")
    public Iterable<Tour>  findAllByDestinationCity(@RequestParam String destinationCity) {
            return tourService.findAllByDestinationCity(destinationCity);
    }
    @GetMapping("tours/search/byCountry")
    public Iterable<Tour> findAllByCountry(@RequestParam String country){
        return tourService.findAllByCountry(country);
    }
    @GetMapping("tours/search/byPrice")
    public Iterable<Tour> findAllByPrice(@RequestParam int price) {
        return tourService.findAllByPrice(price);
    }

    @GetMapping("tours/search/byTitle")
    public Iterable<Tour> findAllByTitle(@RequestParam String title) {
        return tourService.findAllByTitle(title);
    }

    @GetMapping("tours/search/byDepartureFrom")
    public Iterable<Tour> findAllByDepartureFrom(@RequestParam String destinationCity) {
        return tourService.findAllByDepartureFrom(destinationCity);
    }
}