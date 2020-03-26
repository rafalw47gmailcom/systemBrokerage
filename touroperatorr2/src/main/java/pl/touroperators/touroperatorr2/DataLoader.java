package pl.touroperators.touroperatorr2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.touroperators.touroperatorr2.methods.CopyTool;
import pl.touroperators.touroperatorr2.model.*;
import pl.touroperators.touroperatorr2.model.enumclasses.Room;
import pl.touroperators.touroperatorr2.services.*;

import java.time.LocalDate;

@Component
public class DataLoader {

    @Autowired
    private TourService tourService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelLocationService hotelLocationService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    UserService userService;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        HotelLocation hotelLocation = new HotelLocation(1L,"Boczna", "jakas", "ads","dasd","asdasd","asda","asd");

        Hotel hotel = new Hotel( 1L,"Hotelik", 5, "hotel@hotel.com", "dasdasdda","111-222-333",  Room.JEDNOOSOBOWY);
        Hotel hotel1 = new Hotel( 2L,"Hotelik", 5, "hotel@hotel.com", "dasdasdda","111-222-333",  Room.JEDNOOSOBOWY);
        Hotel hotel2 = new Hotel( 3L,"Hotelik", 5, "hotel@hotel.com", "dasdasdda","111-222-333",  Room.JEDNOOSOBOWY);
        Hotel hotel3 = new Hotel( 4L,"Hotelik", 5, "hotel@hotel.com", "dasdasdda","111-222-333",  Room.JEDNOOSOBOWY);
        Hotel hotel4 = new Hotel( 5L,"Hotelik", 5, "hotel@hotel.com", "dasdasdda","111-222-333",  Room.JEDNOOSOBOWY);

        hotelLocationService.save(hotelLocation);

        hotelService.save(hotel);
        hotelService.save(hotel1);
        hotelService.save(hotel2);
        hotelService.save(hotel3);
        hotelService.save(hotel4);

        Tour tour = new Tour(1L, "Wyjazd na Malediwy", LocalDate.of(2020,2 , 12),LocalDate.of(2020, 2, 17), 2000, "Honollu", "Koszalin", "Polska",hotel);
        tourService.save(tour);
        tourService.save(new Tour(2L, "Wyjazd do Hiszpanii",LocalDate.of(2020, 3, 21), LocalDate.of(2020, 4, 1), 1100, "Madryt", "Warszawa", "Hiszpania",hotel4));
         tourService.save(new Tour(3L, "Wyjazd na Madagaskar",LocalDate.of(2020, 5, 15), LocalDate.of(2020, 5, 22), 3000, "Antananarivo", "Koszalin", "Madagaskar",hotel1));
        tourService.save(new Tour(4L, "Wyjazd do Niemiec",LocalDate.of(2020, 6, 11), LocalDate.of(2020, 6, 18), 4500, "Madryt", "Koszalin", "Niemcy",hotel2));
        tourService.save(new Tour(5L, "Wyjazd na Litwe",LocalDate.of(2020, 12, 6), LocalDate.of(2020, 12, 11), 1200, "Madryt", "Poznan", "Litwa",hotel3));


       // User user = new User(1L,"Rafal","jakis","rafal@wp.pl");



       Reservation reservation = new Reservation(1L, "Rafal","Jakis", "asdas@o2.pl");
      //  System.out.println("loader: " + reservation);

       reservation=  CopyTool.copyTourData(reservation, tour);


      //  System.out.println("Rezerwacja w bazie: ");
    //    System.out.println("po uruchomieniu: " + reservation);

      reservationService.save(reservation);





        /*




                tourService.save(new Tour(1L, "Wjazd na Malediwy", new Date(2020, 02, 12), new Date(2020, 02, 17), 2000, "Honollu", "Koszalin", "Polska",hotel));
        tourService.save(new Tour(2L, "Wyjazd na Madagaskar",new Date(2020, 05, 15), new Date(2020, 05, 22), 3000, "Antananarivo", "Koszalin", "Madagaskar",hotel1));
        tourService.save(new Tour(3L, "Wyjazd do Niemiec",new Date(2020, 02, 12), new Date(2020, 02, 12), 4500, "Madryt", "Koszalin", "Niemcy",hotel2));
        tourService.save(new Tour(4L, "Wyjazd na Litwe",new Date(2020, 02, 12), new Date(2020, 02, 12), 1200, "Madryt", "Poznan", "Litwa",hotel3));
        tourService.save(new Tour(5L, "Wyjazd do Hiszpanii",new Date(2020, 02, 12), new Date(2020, 02, 12), 1100, "Madryt", "Warszawa", "Ukraina",hotel4));
         */
    }
}