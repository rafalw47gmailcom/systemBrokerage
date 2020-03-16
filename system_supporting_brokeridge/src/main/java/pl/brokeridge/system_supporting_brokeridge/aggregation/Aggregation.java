package pl.brokeridge.system_supporting_brokeridge.aggregation;




import pl.brokeridge.system_supporting_brokeridge.entity.Tour;
import pl.brokeridge.system_supporting_brokeridge.search.Searcher;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class Aggregation {

    protected static final Logger log = Logger.getLogger(String.valueOf(Aggregation.class));
    public static List<Tour> aggregatedTours = new ArrayList<>();


    public Aggregation() throws MalformedURLException {

    }

    public static List<Tour> searchbyParams(String country, String destinationCity, String dateFrom, String dateTo) throws IOException {
        log.info("------------------------------------------------------------------------------------------------------------------------------");
        log.info("[SEARCHING OFFERS BY PARAMS] Start SEARCHNG offers from touroperators and cleaning the lists");
        log.info("");
        clearLists();

        Searcher searcher = new Searcher(country,  destinationCity,  dateFrom, dateTo, Touroperator.firstUrlParams, Touroperator.secondUrlParams);

        downloadTourOffers(searcher.getUrlWithParams(),Touroperator.Touroperator1);
        downloadTourOffers(searcher.getUrlWithParams2(),Touroperator.Touroperator2);

        log.info("");
        return aggregatedTours;
    }

    public static List<Tour> aggregate() throws IOException {
        log.info("------------------------------------------------------------------------------------------------------------------------------");
        log.info("[AGGREGATING ALL OFFERS] Start aggregating offers from touroperators and cleaning the lists");
        log.info("");
        clearLists();


      downloadTourOffers(Touroperator.firstUrlAll, Touroperator.Touroperator1);
       downloadTourOffers(Touroperator.secondUrlAll, Touroperator.Touroperator2);

       aggregatedTours.sort(Comparator.comparing(Tour::getCountry));

        log.info("");
        return aggregatedTours;
    }

    public static void clearLists(){
        aggregatedTours.clear();
    }

    public static void downloadTourOffers(String url, Touroperator touroperator) throws IOException {
        Downloader firstDownloader = new Downloader(url, touroperator);
        aggregatedTours.addAll(firstDownloader.getDonwloadedTours());
    }


}
