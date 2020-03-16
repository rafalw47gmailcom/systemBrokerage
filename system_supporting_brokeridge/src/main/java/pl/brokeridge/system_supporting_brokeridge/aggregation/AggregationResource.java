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
                return Aggregation.searchbyParams(country,  destinationCity,  dateFrom, dateTo);
        }

/*
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