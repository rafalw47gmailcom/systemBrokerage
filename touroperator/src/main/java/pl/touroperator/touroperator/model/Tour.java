package pl.touroperator.touroperator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTo;

    private int price;

    @NotNull
    private String destinationCity;

    private String departureFrom;

    @NotNull
    private String country;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Hotel hotel;

/*
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL, mappedBy = "tour")
    private  Reservation reservation;

 */
    public Tour() {
    }

    public Tour(Long id, String title, LocalDate dateFrom, LocalDate dateTo, int price, String destinationCity, String departureFrom, String country, Hotel hotel) {
        this.id = id;
        this.title = title;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        this.destinationCity = destinationCity;
        this.departureFrom = departureFrom;
        this.country = country;
      this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


/*
    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
 */

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", price=" + price +
                ", destinationCity='" + destinationCity + '\'' +
                ", departureFrom='" + departureFrom + '\'' +
                ", country='" + country + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}