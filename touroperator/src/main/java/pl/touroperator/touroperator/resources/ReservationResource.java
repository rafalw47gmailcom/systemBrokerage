package pl.touroperator.touroperator.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.touroperator.touroperator.methods.CopyTool;
import pl.touroperator.touroperator.model.Reservation;
import pl.touroperator.touroperator.model.Tour;
import pl.touroperator.touroperator.services.ReservationService;
import pl.touroperator.touroperator.services.TourService;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationResource {

    private ReservationService reservationService;

    private TourService tourService;


    @Autowired
    public ReservationResource(ReservationService reservationService, TourService tourService) {
        this.reservationService = reservationService;
        this.tourService = tourService;

    }



    @GetMapping()
    public String getReservationPage(Model model){
        List<Reservation> reservations = reservationService.findAll();
      //  System.out.println("Lista rezerwacji: ");
     //   System.out.println(reservations);
        model.addAttribute("reservations",reservations);
       // model.addAttribute("newReservation", new Reservation());

        return "reservation";
    }


    @GetMapping("/reservationConfirmed")
    public String confirmReservationAdded(Model model){
        List<Reservation> reservations = reservationService.findAll();
        System.out.println(reservations);
        model.addAttribute("reservations",reservations);
        model.addAttribute("newReservation", new Reservation());

        return "/reservationAdded";
    }

    @PostMapping("/addReservation")
    public String addTour(@ModelAttribute("reservationA") Reservation reservation, @ModelAttribute("tour") Tour tour){


        System.out.println(reservation);
        reservation = CopyTool.copyTourData(reservation, tour);

        System.out.println(reservation);

       // reservation.setTour(tour);
       // System.out.println("reservation.getTpour " + reservation.getTour());
    //    System.out.println("rezerwacja" + reservation);


     //   System.out.println("przed: " + tourService.findAllAsList());
          reservationService.save(reservation);
     //   System.out.println("po: " + tourService.findAllAsList());

        return "redirect:/reservations/reservationConfirmed";
    }




    // reservation.setTour(tour);


        /*
                System.out.println("Tour: ");
        System.out.println(tour.getTitle());
       System.out.println(tour.getCountry());
        System.out.println(tour.getDestinationCity());
        System.out.println(tour.getDateFrom());
        System.out.println(tour.getDateTo());
        System.out.println(tour.getPrice());

        System.out.println("Reservation.tour");


         */



    //   Reservation reservation1 = new Reservation(tour, reservation.getFirstName(), reservation.getLastName(), reservation.getEmail());
    //  reservation.setTour(tour);


/*
        System.out.println("Reservation: ");
        System.out.println(reservation.getFirstName());
        System.out.println(reservation.getLastName());
        System.out.println(reservation.getEmail());
 */

/*

    @PostMapping("/add")
    public String addTour(@ModelAttribute("tour") Tour tour){
        tourService.save(tour);
        return "redirect:/admin";
    }
 */
}

