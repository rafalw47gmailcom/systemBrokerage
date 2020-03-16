package pl.touroperator.touroperator.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touroperator.touroperator.model.Tour;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TourRepo extends JpaRepository<Tour,Long> {

    List<Tour> findAllByCountryAndDestinationCityAndDateFromAndDateTo(String country, String destinationCity, LocalDate dateFrom, LocalDate dateTo);


    Iterable<Tour>  findAllByCountry(String country);

    Iterable<Tour> findAllByPrice(int price);

    Iterable<Tour>  findAllByTitle(String title);

    Iterable<Tour> findAllByDestinationCity(String destinationCity);

    Iterable<Tour> findAllByDepartureFrom(String destinationCity);

    List<Tour> findAllByTitleLike(String title);

    List<Tour> findAllByCountryLike(String country);

    List<Tour> findAllByDestinationCityLike(String destination);

    List<Tour> findAllByDateFromLike(LocalDate dateFrom);

    List<Tour> findAllByDateToLike(LocalDate dateTo);

    List<Tour> findAllByPriceLike(int price);


   /*
       Iterable<Tour> findAllById();

    Iterable<Tour> findByCountryOrAndDestinationCity(String country, String destinationCity);
            <th style="color: #45a049" scope="col">Miejsce przylotu</th>
            <th style="color: #45a049" scope="col">Data wyjazdu</th>
            <th style="color: #45a049" scope="col">Powrót przed</th>
               Iterable<Tour> findAllByCountryAndAndDateFromAndAndDateTo(String country, LocalDate dateFrom, LocalDate dateTo);

    Iterable<Tour> findAllByPriceAndAndDateFromAndAndDateTo(String price, String dateFrom, String dateTo);

    Iterable<Tour> findAllByTitleAndAndDateFromAndAndDateTo(String title, String dateFrom, String dateTo);

    Iterable<Tour> findAllByDestinationCityAndAndDateFromAndAndDateTo(String DestinationCity, String dateFrom, String dateTo);

    Iterable<Tour> findAllByDepartureFromAndAndDateFromAndAndDateTo(String cDepartureFrom, String dateFrom, String dateTo);
     */

}




