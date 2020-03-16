package pl.touroperators.touroperatorr2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.touroperators.touroperatorr2.Touroperatorr2Application;
import pl.touroperators.touroperatorr2.methods.CopyTool;
import pl.touroperators.touroperatorr2.model.Reservation;
import pl.touroperators.touroperatorr2.model.ReservationExternal;
import pl.touroperators.touroperatorr2.model.Tour;
import pl.touroperators.touroperatorr2.services.ReservationService;
import pl.touroperators.touroperatorr2.services.TourService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TourResource {

    protected static final java.util.logging.Logger log = Logger.getLogger(String.valueOf(Touroperatorr2Application.class));


    private TourService tourService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    public TourResource(TourService tourService) {
   //     this.reservationService = reservationService;
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


    @GetMapping("/reservation")
    public void reservateTour(@RequestParam(defaultValue = "") String firstName,
                              @RequestParam(defaultValue = "") String lastName,
                              @RequestParam(defaultValue = "") String email,
                              @RequestParam(defaultValue = "") String title,
                              @RequestParam(defaultValue = "") String dateFrom,
                              @RequestParam(defaultValue = "") String dateTo,
                              @RequestParam(defaultValue = "") int price,
                              @RequestParam(defaultValue = "") String destinationCity,
                              @RequestParam(defaultValue = "") String departureFrom,
                              @RequestParam(defaultValue = "") String country){


        log.info("------------------------------------------------------------------------------------------------------------------------------");
        log.info("Rezerwacja z zewnetrznego źródła dodana. Rezerwujący: " + firstName + " " + lastName);
        log.info("------------------------------------------------------------------------------------------------------------------------------");

        LocalDate dateFrom2 = LocalDate.parse(dateFrom);
        LocalDate dateTo2 = LocalDate.parse(dateTo);

        Reservation reservation = new Reservation(firstName,lastName,email,title,dateFrom2,dateTo2,price,destinationCity,departureFrom,country);

        reservationService.save(reservation);
    }



    @GetMapping(path ="/reservation2" , consumes = "application/json", produces = "application/json")
    public ReservationExternal reservateTour2(@RequestBody ReservationExternal reservationExternal){

  //      System.out.println("cos");

        Reservation reservation = new Reservation();

        CopyTool.copyDataFromExternalReservation(reservation, reservationExternal);
     //   reservationService.save(reservation);

        return new ReservationExternal();
    }


/*

    @GetMapping("/reservationlist/all")
    public List<Reservation> getReservations(){
        List<Reservation> reservations = reservationService.findAll();

        return reservations;
    }

    @GetMapping("/example")
    public ReservationExternal example(){
        List<Reservation> reservations = reservationService.findAll();

        ReservationExternal reservationExternal = new ReservationExternal("asd","asdasd","asdasd","sadasd","asdas","asdas",12,"sada", "sada", "sada");

        System.out.println(reservationExternal);
        return reservationExternal;

    }

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
 */



}