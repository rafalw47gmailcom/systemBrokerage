package pl.touroperator.touroperator.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.touroperator.touroperator.model.Reservation;
import pl.touroperator.touroperator.model.Tour;
import pl.touroperator.touroperator.services.ReservationService;
import pl.touroperator.touroperator.services.TourService;

import java.time.LocalDate;
import java.util.List;

//localhost:8080/admin


@Controller
@RequestMapping("/admin")
public class AdminPageResource {

    private TourService tourService;

    private ReservationService reservationService;



    @Autowired
    public AdminPageResource(TourService tourService, ReservationService reservationService) {
        this.tourService = tourService;
        this.reservationService = reservationService;
    }


    @GetMapping()
    public String get(Model model){
        List<Tour> tours = tourService.findAllAsList();
        model.addAttribute("tours",tours);
  //    model.addAttribute("newTour", new Tour());
        return "/admin";
    }

    @GetMapping("/params")
    public String findAllByCountryAndDestinationCityAndDateFromAndDateTo(Model model,
                                                                         @RequestParam(defaultValue = "") String country,
                                                                         @RequestParam(defaultValue = "") String destinationCity,
                                                                         @RequestParam(defaultValue = "") String dateFrom,
                                                                         @RequestParam(defaultValue = "") String dateTo){

        LocalDate dateFrom2 = LocalDate.parse(dateFrom);
        LocalDate dateTo2 = LocalDate.parse(dateTo);

        List<Tour> tours = tourService.findAllByCountryAndDestinationCityAndDateFromAndDateTo(country,destinationCity, dateFrom2, dateTo2);
        model.addAttribute("tours",tours);

        return "/admin";
    }



    @GetMapping("/newOffer")
    public String getNewOfferPage(Model model){
        List<Tour> tours = tourService.findAllAsList();
        model.addAttribute("tours",tours);
        model.addAttribute("newTour", new Tour());

        return "new_offer";
    }

    @GetMapping("/reservation")
    public String getReservationPage(Model model){
        List<Reservation> reservations = reservationService.findAll();
        model.addAttribute("reservations",reservations);
        model.addAttribute("newReservation", new Reservation());

        return "reservation";
    }

    @PostMapping("/add")
    public String addTour(@ModelAttribute("tour") Tour tour){

        tourService.save(tour);
        return "redirect:/admin";
    }



    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTourForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_tour");

       // Optional<Tour> tour = tourService.findById(id);
        Tour tour = tourService.getById(id);
        modelAndView.addObject("tour", tour);

        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteTour(@PathVariable(name = "id") Long id){
        tourService.deleteById(id);

        return "redirect:/admin";
    }

    @GetMapping("/details/{id}")
    public ModelAndView getDetails(@PathVariable(name = "id") Long id ){
        ModelAndView modelAndView = new ModelAndView("details");

        // Optional<Tour> tour = tourService.findById(id);
        Tour tour = tourService.getById(id);
        modelAndView.addObject("tour", tour);
        return modelAndView;
    }



}
