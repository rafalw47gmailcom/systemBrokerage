package pl.brokeridge.system_supporting_brokeridge.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import pl.brokeridge.system_supporting_brokeridge.aggregation.Touroperator;

public class Tour {
    @SerializedName("brokerId")
    @Expose
    private Long brokerId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("dateFrom")
    @Expose
    private String dateFrom;
    @SerializedName("dateTo")
    @Expose
    private String dateTo;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("destinationCity")
    @Expose
    private String destinationCity;
    @SerializedName("departureFrom")
    @Expose
    private String departureFrom;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("touroperatorKind")
    @Expose
    private Touroperator touroperator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public Touroperator getTouroperator() {
        return touroperator;
    }

    public void setTouroperator(Touroperator touroperator) {
        this.touroperator = touroperator;
    }
}

















