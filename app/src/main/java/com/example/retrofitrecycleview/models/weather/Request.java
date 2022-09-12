
package com.example.retrofitrecycleview.models.weather;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Request {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("unit")
    @Expose
    private String unit;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Request() {
    }

    /**
     * 
     * @param unit
     * @param query
     * @param language
     * @param type
     */
    public Request(String type, String query, String language, String unit) {
        super();
        this.type = type;
        this.query = query;
        this.language = language;
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
