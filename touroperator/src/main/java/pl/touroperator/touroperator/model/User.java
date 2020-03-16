package pl.touroperator.touroperator.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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




/*
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL
           )
    private UserProfile userProfile;


 */

    public User() {

    }

    public User(Long id,String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

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
}