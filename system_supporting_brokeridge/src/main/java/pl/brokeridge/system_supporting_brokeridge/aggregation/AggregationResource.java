package pl.brokeridge.system_supporting_brokeridge.aggregation;

import org.springframework.web.bind.annotation.*;
import pl.brokeridge.system_supporting_brokeridge.entity.Tour;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/brokerapi")
@CrossOrigin
public class AggregationResource {

        @GetMapping("/tours/all")
        public List<Tour>sendAggregatedData()throws IOException{
        return Aggregation.aggregate();
        }

        @GetMapping("/tours/searchByParams")
        public List<Tour> findAllByCountryAndDestinationCityAndDateFromAndDateTo(@RequestParam(defaultValue = "") String country,
                                                                                 @RequestParam(defaultValue = "") String destinationCity,
                                                                                 @RequestParam(defaultValue = "") String dateFrom,
                                                                                 @RequestParam(defaultValue = "") String dateTo)        throws IOException{
                return Aggregation.searchByParams(country,  destinationCity,  dateFrom, dateTo);
        }








/*




        @GetMapping("/reservationByBroker")
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


         //       log.info("------------------------------------------------------------------------------------------------------------------------------");
         //       log.info("Rezerwacja z zewnetrznego źródła dodana. Rezerwujący: " + firstName + " " + lastName);
         //       log.info("------------------------------------------------------------------------------------------------------------------------------");

                LocalDate dateFrom2 = LocalDate.parse(dateFrom);
                LocalDate dateTo2 = LocalDate.parse(dateTo);


                URL url = new URL("http://localhost:8081/api/reservation");
                InputStreamReader reader = new InputStreamReader(url.openStream());

                Type collectionType = new TypeToken<Collection<Tour>>(){}.getType();
                Collection<Tour> tours = new Gson().fromJson(reader, collectionType);

                for (Tour tour:tours) {
                        tour.setTouroperator(touroperator);
                }

                tmplist.addAll(tours);
                log.info("Ended downloading tour offers from " + touroperator.getUrlAll());
                log.info("..............");
                return tmplist;





                Reservation reservation = new Reservation(firstName,lastName,email,title,dateFrom2,dateTo2,price,destinationCity,departureFrom,country);

                reservationService.save(reservation);
        }












        @GetMapping("/tours")
        public Stream<Tour> findByDestinationCity(@RequestParam Optional<String> destinationCity) throws IOException {

       //     return Aggregation.filterByDestinationCity(destinationCity.orElse("_"));
        return Aggregation.filterByDestinationCity(destinationCity);
         }

 */
/*
    @GetMapping("/tours")
    public Stream<Tour>sendAggregatedDataByDestinationCity(@RequestParam destinationCity) throws IOException {

        return Aggregation.filterByDestinationCity(destinationCity);
    }

        @GetMapping("/tours/all")
        public static Stream<Tour> filterByDestinationCity(@RequestParam Optional<String> destinationCity) throws IOException {
            return Aggregation.filterByDestinationCity(destinationCity);
        }
 */
}