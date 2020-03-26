package pl.brokeridge.system_supporting_brokeridge.reservation;

import org.springframework.web.bind.annotation.*;
import pl.brokeridge.system_supporting_brokeridge.SystemSupportingBrokeridgeApplication;
import pl.brokeridge.system_supporting_brokeridge.aggregation.Touroperator;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
@CrossOrigin
public class ReservationResource {

    protected static final java.util.logging.Logger log = Logger.getLogger(String.valueOf(SystemSupportingBrokeridgeApplication.class));

    @GetMapping("/brokerapi/reservationByBroker")
    public void reservateTour(@RequestParam(defaultValue = "") String firstName,
                              @RequestParam(defaultValue = "") String lastName,
                              @RequestParam(defaultValue = "") String email,
                              @RequestParam(defaultValue = "") String title,
                              @RequestParam(defaultValue = "") String dateFrom,
                              @RequestParam(defaultValue = "") String dateTo,
                              @RequestParam(defaultValue = "") int price,
                              @RequestParam(defaultValue = "") String destinationCity,
                              @RequestParam(defaultValue = "") String departureFrom,
                              @RequestParam(defaultValue = "") String country) throws IOException {

        log.info("------------------------------------------------------------------------------------------------------------------------------");
        log.info("Reservation of trip. Name and surname: " + firstName + " " + lastName);
        log.info("------------------------------------------------------------------------------------------------------------------------------");

        ReservationSender.reservate(firstName, lastName, email, title,
                                    dateFrom, dateTo, price, destinationCity,
                                    departureFrom, country, Touroperator.TOUROPERATOR2);
    }
}