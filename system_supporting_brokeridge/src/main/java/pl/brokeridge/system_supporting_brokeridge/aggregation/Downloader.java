package pl.brokeridge.system_supporting_brokeridge.aggregation;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pl.brokeridge.system_supporting_brokeridge.entity.Tour;
import pl.brokeridge.system_supporting_brokeridge.search.Searcher;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class Downloader {

    protected static final Logger log = Logger.getLogger(String.valueOf(Aggregation.class));
    private List<Tour> donwloadedTours;
    private Touroperator touroperator;

    public Downloader(Searcher searcher){
    };

    public Downloader(String url, Touroperator touroperator) throws IOException {
        this.touroperator = touroperator;
        log.info("[START] Start downloading offers from " + url);


        this.donwloadedTours = getDownloadedTours(url, touroperator);
    }

    private static List<Tour> getDownloadedTours(String url, Touroperator touroperator) throws IOException {
        List<Tour> tmplist = new ArrayList<>();

        URL url2 = new URL(url);
        InputStreamReader reader = new InputStreamReader(url2.openStream());

        Type collectionType = new TypeToken<Collection<Tour>>(){}.getType();
        Collection<Tour> tours = new Gson().fromJson(reader, collectionType);


        for (Tour tour:tours) {
            tour.setTouroperator(touroperator);
        }
      //  tours.iterator().next().setTouroperator(touroperator);

        tmplist.addAll(tours);
        log.info("[END] Ended downloading tour offers from " + url);
        return tmplist;
    }

    public List<Tour> getDonwloadedTours() {
        return donwloadedTours;
    }

    public Touroperator getTouroperator() {
        return touroperator;
    }

}

