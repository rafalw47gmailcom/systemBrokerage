package pl.brokeridge.system_supporting_brokeridge.aggregation;


public enum Touroperator {
    TOUROPERATOR1(  "http://localhost:8080/api/tours/allAsList",
                "http://localhost:8080/api/params",
             "http://localhost:8080/api/reservation"),
    TOUROPERATOR2("http://localhost:8081/api/tours/allAsList",
               "http://localhost:8081/api/params",
            "http://localhost:8081/api/reservation");

    private final String urlAll;
    private final String urlParams;
    private final String urlReservation;
    private String currentUrl;

    Touroperator(String urlAll, String urlParams, String urlReservation) {
        this.urlAll = urlAll;
        this.urlParams = urlParams;
        this.urlReservation = urlReservation;
    }

    public String getUrlAll() {
        return urlAll;
    }

    public String getUrlParams() {
        return urlParams;
    }

    public String getUrlReservation() {
        return urlReservation;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public void setCurrentUrl(String currentUrl) {
        this.currentUrl = currentUrl;
    }

    // private String firstUrlAll = "http://localhost:8080/api/tours/allAsList";

  //  private String secondUrlAll = "http://localhost:8081/api/tours/allAsList";

   // private String firstUrlParams = "http://localhost:8080/api/params";

  //  private String secondUrlParams = "http://localhost:8081/api/params";




}

/*



Touroperator(String urlAll, String urlParams) {
    }
 */