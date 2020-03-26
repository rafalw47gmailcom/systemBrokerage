package pl.brokeridge.system_supporting_brokeridge.aggregation;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pl.brokeridge.system_supporting_brokeridge.entity.Tour;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class Downloader {
    protected static final Logger log = Logger.getLogger(String.valueOf(Aggregation.class));
    private static List<Tour> downloadedTours;
    private Touroperator touroperator;
    private static long loopValue = 0;

    public Downloader(Touroperator touroperator)
            throws IOException {
        this.touroperator = touroperator;
        log.info("Start downloading offers from "
                + touroperator.getCurrentUrl());
        this.downloadedTours = downloadTours(touroperator);
    }
    private static List<Tour> downloadTours(Touroperator touroperator)
            throws IOException {
        List<Tour> tmplist = new ArrayList<>();
        URL url2 = new URL(touroperator.getCurrentUrl());
        InputStreamReader reader = new InputStreamReader(url2.openStream());
        Type collectionType = new TypeToken<Collection<Tour>>(){}.getType();
        Collection<Tour> tours = new Gson().fromJson(reader, collectionType);
        for (Tour tour:tours) {
            tour.setTouroperator(touroperator);
            tour.setBrokerId(loopValue);
            loopValue++;
        }
        tmplist.addAll(tours);
        log.info("Ended downloading tour offers from "
                + touroperator.getCurrentUrl());
        log.info("..............");
        return tmplist;
    }
    public List<Tour> getDownloadedTours() {
        return downloadedTours;
    }
    public Touroperator getTouroperator() {
        return touroperator;
    }
    public static void setLoopValueOnZero() {
        Downloader.loopValue = 0;
    }}






