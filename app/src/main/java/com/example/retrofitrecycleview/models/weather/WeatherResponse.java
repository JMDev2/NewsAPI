
package com.example.retrofitrecycleview.models.weather;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class WeatherResponse {

    @SerializedName("request")
    @Expose
    private Request request;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("current")
    @Expose
    private Current current;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeatherResponse() {
    }

    /**
     * 
     * @param request
     * @param current
     * @param location
     */
    public WeatherResponse(Request request, Location location, Current current) {
        super();
        this.request = request;
        this.location = location;
        this.current = current;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

}
