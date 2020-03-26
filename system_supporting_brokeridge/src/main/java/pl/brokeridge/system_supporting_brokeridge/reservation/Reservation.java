package pl.brokeridge.system_supporting_brokeridge.reservation;

import pl.brokeridge.system_supporting_brokeridge.aggregation.Touroperator;

public class Reservation {

    private String params;

    private String touroperatorUrl;

    private String brokerageUrl;

    public Reservation(String firstName, String lastName, String email, String title, String dateFrom, String dateTo, int price,
                       String destinationCity, String departureFrom, String country, Touroperator touroperator) {

        params = "?firstName=" + firstName + "&lastName=" + lastName + "&email=" + email + "&title=" + title
                + "&dateFrom=" + dateFrom + "&dateTo=" + dateTo + "&price=" + price + "&destinationCity=" + destinationCity + "&departureFrom=" + departureFrom + "&country=" + country;

        touroperatorUrl = touroperator.getUrlReservation() + params;

        brokerageUrl = "http://localhost:8082/brokerapi/reservationByBroker" + params;


    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getTouroperatorUrl() {
        return touroperatorUrl;
    }

    public void setTouroperatorUrl(String touroperatorUrl) {
        this.touroperatorUrl = touroperatorUrl;
    }

    public String getBrokerageUrl() {
        return brokerageUrl;
    }

    public void setBrokerageUrl(String brokerageUrl) {
        this.brokerageUrl = brokerageUrl;
    }
}

/*
        private String firstName;
        private String lastName;
        private String email;
        private String title;
        private String dateFrom;
        private String dateTo;
        private int price;
        private String destinationCity;
        private String departureFrom;
        private String country;
 */