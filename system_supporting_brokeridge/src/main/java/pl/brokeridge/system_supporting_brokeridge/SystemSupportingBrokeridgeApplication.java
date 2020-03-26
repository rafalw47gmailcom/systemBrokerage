package pl.brokeridge.system_supporting_brokeridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.brokeridge.system_supporting_brokeridge.aggregation.Aggregation;
import pl.brokeridge.system_supporting_brokeridge.aggregation.Touroperator;
import pl.brokeridge.system_supporting_brokeridge.reservation.Reservation;
import pl.brokeridge.system_supporting_brokeridge.reservation.ReservationSender;
import pl.brokeridge.system_supporting_brokeridge.search.Searcher;

import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.Logger;

@SpringBootApplication
public class SystemSupportingBrokeridgeApplication {

    protected static final java.util.logging.Logger log = Logger.getLogger(String.valueOf(SystemSupportingBrokeridgeApplication.class));

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SystemSupportingBrokeridgeApplication.class, args);

        log.info("------------------------------------------------------------------------------------------------------------------------------");
        log.info("System supporting brokeridge run on: ");
        log.info(" ");
        log.info("http://localhost:8082/brokerapi/tours/all");
        log.info(" ");
        log.info("http://localhost:8082/brokerapi/tours/searchByParams?country=Polska&destinationCity=Honollu&dateFrom=2020-02-12&dateTo=2020-02-17");
        log.info("------------------------------------------------------------------------------------------------------------------------------");

        String firstName = "dasd";
        String lastName = "sadsa";
        String email = "sadsa";
        String title = "sada";
        String dateFrom = "2002-02-12";
        String dateTo = "2002-02-12";
        int price = 12;
        String destinationCity = "as";
        String departureFrom = "dsad";
        String country = "asaa";

       Reservation reservation = new Reservation(   firstName, lastName, email, title,
               dateFrom, dateTo, price, destinationCity,
        departureFrom, country, Touroperator.TOUROPERATOR2);


       // log.info(reservation.getTouroperatorUrl());


        log.info("Przykklad rezerwacji");
        log.info(reservation.getBrokerageUrl());


        log.info("http://localhost:8082/home");

        log.info("--------------------");
        log.info("http://localhost:8082/searchByParams?country=Polska&destinationCity=Honollu&dateFrom=2020-02-12&dateTo=2020-02-17");



}
}
