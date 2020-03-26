package pl.brokeridge.system_supporting_brokeridge.search;

import pl.brokeridge.system_supporting_brokeridge.aggregation.Touroperator;

public class Searcher {
    private String urlWithParams;
    private String urlWithParams2;
    private String  brokeridgeUrl;

    public Searcher(String country,
                    String destinationCity,
                    String dateFrom,
                    String dateTo,
                    Touroperator touroperator,
                    Touroperator touroperatorSecond) {

        urlWithParams = touroperator.getUrlParams()
                + "?country="
                + country
                + "&destinationCity="
                + destinationCity
                + "&dateFrom="
                + dateFrom
                + "&dateTo="
                + dateTo;
        urlWithParams2 = touroperatorSecond.getUrlParams()
                + "?country="
                + country
                + "&destinationCity="
                + destinationCity
                + "&dateFrom="
                + dateFrom
                + "&dateTo="
                + dateTo;
        brokeridgeUrl = "http://localhost:8082/brokerapi/tours/searchByParams"
                + "?country="
                + country
                + "&destinationCity="
                + destinationCity
                + "&dateFrom="
                + dateFrom
                + "&dateTo="
                + dateTo;
    }

    public String getUrlWithParams() {
        return urlWithParams;
    }

    public void setUrlWithParams(String urlWithParams) {
        this.urlWithParams = urlWithParams;
    }

    public String getUrlWithParams2() {
        return urlWithParams2;
    }

    public void setUrlWithParams2(String urlWithParams2) {
        this.urlWithParams2 = urlWithParams2;
    }

    public String getBrokeridgeUrl() {
        return brokeridgeUrl;
    }

    public void setBrokeridgeUrl(String brokeridgeUrl) {
        this.brokeridgeUrl = brokeridgeUrl;
    }
}
