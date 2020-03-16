package pl.touroperators.touroperatorr2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.touroperators.touroperatorr2.methods.CopyTool;
import pl.touroperators.touroperatorr2.model.Reservation;
import pl.touroperators.touroperatorr2.model.ReservationExternal;
import pl.touroperators.touroperatorr2.model.Tour;
import pl.touroperators.touroperatorr2.services.ReservationService;
import pl.touroperators.touroperatorr2.services.TourService;

import java.time.LocalDate;
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
        model.addAttribute("reservations",reservations);
       // model.addAttribute("newReservation", new Reservation());

        return "reservation";
    }

    @GetMapping("/reservationConfirmed")
    public String confirmReservationAdded(Model model){
        List<Reservation> reservations = reservationService.findAll();
        model.addAttribute("reservations",reservations);
        model.addAttribute("newReservation", new Reservation());

        return "/reservationAdded";
    }

    @PostMapping("/addReservation")
    public String addTour(@ModelAttribute("reservationA") Reservation reservation, @ModelAttribute("tour") Tour tour){
          reservation = CopyTool.copyTourData(reservation, tour);
          reservationService.save(reservation);

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

