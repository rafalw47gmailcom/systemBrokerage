package pl.touroperators.touroperatorr2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.touroperators.touroperatorr2.model.Reservation;
import pl.touroperators.touroperatorr2.model.Tour;
import pl.touroperators.touroperatorr2.services.TourService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserPageResource {

    private TourService tourService;

    @Autowired
    public UserPageResource(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping()
    public String get(Model model){
       List<Tour> tours = tourService.findAllAsList();
       model.addAttribute("tours",tours);
        return "/userPages/homepage";
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

        return "/userPages/homepage";
    }

    @GetMapping("/offerdetails/{id}")
    public ModelAndView getOfferDetails(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/userPages/detailsUser");
        // Optional<Tour> tour = tourService.findById(id);
        Tour tour = tourService.getById(id);
        modelAndView.addObject("tour", tour);
       modelAndView.addObject("reservation", new Reservation());
        return modelAndView;
    }
}
