package pl.brokeridge.system_supporting_brokeridge.search;

public class Searcher {

    private String urlWithParams;
    private String urlWithParams2;
    private String  brokeridgeUrl;

    public Searcher(String country, String destinationCity, String dateFrom, String dateTo, String url, String url2) {

        urlWithParams = url + "?country=" + country + "&destinationCity=" + destinationCity + "&dateFrom=" + dateFrom + "&dateTo=" + dateTo;
        urlWithParams2 = url2 + "?country=" + country + "&destinationCity=" + destinationCity + "&dateFrom=" + dateFrom + "&dateTo=" + dateTo;

        brokeridgeUrl = "http://localhost:8083/brokerapi/tours/searchByParams" + "?country=" + country + "&destinationCity=" + destinationCity + "&dateFrom=" + dateFrom + "&dateTo=" + dateTo;

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
