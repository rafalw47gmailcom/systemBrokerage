package pl.touroperator.touroperator.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.touroperator.touroperator.model.Reservation;
import pl.touroperator.touroperator.model.Tour;
import pl.touroperator.touroperator.services.TourService;

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

/*

    @PostMapping("/checkParams")
    public String checkTourSearchInfo(@Valid Tour tour, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/userPages/homepage";
        }

        return "redirect:/params";
    }
 */

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

    /*
            switch (value){
            case "title":
                 tours = tourService.findAllByTitleLike(search);
            case "destination":
                 tours = tourService.findAllByDestinationCityLike(search);
            case "dateFrom":
                LocalDate searchDate = LocalDate.parse(search);
                 tours = tourService.findAllByDateFromLike(searchDate);
            case "dateTo":
                LocalDate searchDate2 = LocalDate.parse(search);
                tours = tourService.findAllByDateToLike(searchDate2);
            case "price":
                int searchPrice = Integer.parseInt(search);
                tours = tourService.findAllByPriceLike(searchPrice);
            default:
                tours = tourService.findAllByCountryLike(search);
        }
     */