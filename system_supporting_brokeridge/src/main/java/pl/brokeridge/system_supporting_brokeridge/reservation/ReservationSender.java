package pl.brokeridge.system_supporting_brokeridge.reservation;

import pl.brokeridge.system_supporting_brokeridge.SystemSupportingBrokeridgeApplication;
import pl.brokeridge.system_supporting_brokeridge.aggregation.Touroperator;
import pl.brokeridge.system_supporting_brokeridge.entity.Tour;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public class ReservationSender {

    protected static final java.util.logging.Logger log = Logger.getLogger(String.valueOf(SystemSupportingBrokeridgeApplication.class));

    public static void reservate( String firstName, String lastName, String email, String title, String dateFrom, String dateTo, int price,
                                        String destinationCity, String departureFrom, String country, Touroperator touroperator) throws IOException {
        log.info("------------------------------------------------------------------------------------------------------------------------------");

        Reservation reservation = new Reservation(firstName, lastName, email, title,dateFrom, dateTo, price,
        destinationCity, departureFrom, country, touroperator);

        URL url2 = new URL(reservation.getTouroperatorUrl());
       InputStreamReader reader = new InputStreamReader(url2.openStream());
        log.info("Reservation added" );

    }
}