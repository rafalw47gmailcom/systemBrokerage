package pl.touroperator.touroperator.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /*    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private  Tour tour;

     */


    // @NotNull(message = "nie może być puste")
    //  @Size(max = 15)
    private String firstName;

    // @NotNull(message = "nie może być puste")
    //  @Size(max = 30)
    private String lastName;

    //   @NotNull(message = "nie może być puste")
    //  @Email
    //  @Size(max = 50)
    //   @Column(unique = true)
    private String email;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTo;

    private int price;

    private String destinationCity;

    private String departureFrom;

    private String country;

    public Reservation(Long id,  String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Reservation(Long id,  String firstName, String lastName,String title, String email, LocalDate dateFrom, LocalDate dateTo, int price,
                       String destinationCity, String departureFrom, String country ) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        this.destinationCity = destinationCity;
        this.departureFrom = departureFrom;
        this.country = country;
    }

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}