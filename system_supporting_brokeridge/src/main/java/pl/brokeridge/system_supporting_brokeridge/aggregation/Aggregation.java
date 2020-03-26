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
    public Aggregation() throws MalformedURLException { }

    public static List<Tour> searchByParams(String country, String destinationCity, String dateFrom, String dateTo)
            throws IOException {
        log.info("------------------------------------------------------------------------------------------------------------------------------");
        log.info("[SEARCHING OFFERS BY PARAMS] Start SEARCHNG offers from touroperators and cleaning the lists");
        log.info("");
        clearList();
        Searcher searcher = new Searcher(country,  destinationCity,  dateFrom, dateTo,
                Touroperator.TOUROPERATOR1, Touroperator.TOUROPERATOR2);
        downloadTourOffersByParams(searcher.getUrlWithParams(),Touroperator.TOUROPERATOR1);
        downloadTourOffersByParams(searcher.getUrlWithParams2(),Touroperator.TOUROPERATOR2);
        Downloader.setLoopValueOnZero();
        log.info("");
        return aggregatedTours;
    }
    public static List<Tour> aggregate() throws IOException {
        log.info("------------------------------------------------------------------------------------------------------------------------------");
        log.info("[AGGREGATING ALL OFFERS] Start aggregating offers from touroperators and cleaning the lists");
        log.info("");
        clearList();
        downloadAllTourOffers(Touroperator.TOUROPERATOR1);
        downloadAllTourOffers(Touroperator.TOUROPERATOR2);
        Downloader.setLoopValueOnZero();
       aggregatedTours.sort(Comparator.comparing(Tour::getCountry));
        log.info("Aggregating offers");
        log.info("");
        return aggregatedTours;
    }
    public static void clearList(){
        aggregatedTours.clear();
    }
    public static void downloadTourOffersByParams(String paramsURL, Touroperator touroperator) throws IOException {
        touroperator.setCurrentUrl(paramsURL);
        Downloader downloader = new Downloader(touroperator);
        aggregatedTours.addAll(downloader.getDownloadedTours());
    }
    public static void downloadAllTourOffers(Touroperator touroperator) throws IOException {
        touroperator.setCurrentUrl(touroperator.getUrlAll());
        Downloader downloader = new Downloader(touroperator);
        aggregatedTours.addAll(downloader.getDownloadedTours());
    }
    public static List<Tour> getAggregatedTours() {
        return aggregatedTours;
    }
}










