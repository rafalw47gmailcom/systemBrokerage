package pl.brokeridge.system_supporting_brokeridge.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.brokeridge.system_supporting_brokeridge.aggregation.Aggregation;
import pl.brokeridge.system_supporting_brokeridge.entity.Tour;

import java.io.IOException;
import java.util.List;

@Controller
public class Resource {

    @GetMapping("/home")
    public String getIndex(){
       // List<Tour> tours = tourService.findAllAsList();
      //  model.addAttribute("tours",tours);
        return "/index";
    }
    @GetMapping("/contact")
    public String getContact(){
        // List<Tour> tours = tourService.findAllAsList();
        //  model.addAttribute("tours",tours);
        return "/kontakt";
    }
    @GetMapping("/aboutUs")
    public String getAboutUs(){
        // List<Tour> tours = tourService.findAllAsList();
        //  model.addAttribute("tours",tours);
        return "oNas";
    }
    @GetMapping("/allOffers")
    public String getAll(Model model) throws IOException {
         List<Tour> tours = Aggregation.aggregate();
          model.addAttribute("tours",tours);
        return "/allOffers";
    }
    @GetMapping("/details/{id}")
    public ModelAndView getDetails(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/offerDetails");

        List<Tour> tours = Aggregation.getAggregatedTours();
        Tour properTour = null;
        for (Tour tour: tours) {
            if(tour.getBrokerId() == id)
                properTour = tour;
        }
        modelAndView.addObject("properTour", properTour);

        return modelAndView;
    }
  //  @GetMapping("/offerdetails/{id}")
   // public ModelAndView getOfferDetails(){

        // Optional<Tour> tour = tourService.findById(id);
       // Tour tour = tourService.getById(id);
     //   modelAndView.addObject("tour", tour);
     //   modelAndView.addObject("reservation", new Reservation());
     //   return modelAndView;
   // }
    @GetMapping("/searchByParams")
    public String getToursByParams(Model model,
                                   @RequestParam(defaultValue = "") String country,
                                   @RequestParam(defaultValue = "") String destinationCity,
                                   @RequestParam(defaultValue = "") String dateFrom,
                                   @RequestParam(defaultValue = "") String dateTo) throws IOException {

         List<Tour> searchedTours = Aggregation.searchByParams(country,  destinationCity,  dateFrom, dateTo);


         model.addAttribute("searchedTours",searchedTours);
        return "searchedOffers";
    }
}