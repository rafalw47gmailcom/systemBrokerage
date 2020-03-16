package pl.touroperators.touroperatorr2.model;

import pl.touroperators.touroperatorr2.model.enumclasses.Room;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Hotel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @Column(nullable = false)
    private String name;

  //  @NotNull(message = "nie może być puste")
    private int stars;

   // @NotNull(message = "nie może być puste")
    private String email;

    private String description;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Room room;




    /*
        @OneToOne(mappedBy = "hotel")
    private Tour tour;
        @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn
    private HotelLocation hotelLocation;
     */

    public Hotel() {
    }

    public Hotel(Long id,String name, @NotNull int stars, @NotNull String email, String description, String phone, Room room) {
        this.id =id;
        this.name = name;
        this.stars = stars;
        this.email = email;
        this.description = description;
        this.room = room;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}