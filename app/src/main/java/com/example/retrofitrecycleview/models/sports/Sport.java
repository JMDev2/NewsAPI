
package com.example.retrofitrecycleview.models.sports;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Sport {

    @SerializedName("idSport")
    @Expose
    private String idSport;
    @SerializedName("strSport")
    @Expose
    private String strSport;
    @SerializedName("strFormat")
    @Expose
    private String strFormat;
    @SerializedName("strSportThumb")
    @Expose
    private String strSportThumb;
    @SerializedName("strSportIconGreen")
    @Expose
    private String strSportIconGreen;
    @SerializedName("strSportDescription")
    @Expose
    private String strSportDescription;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sport() {
    }

    /**
     * 
     * @param idSport
     * @param strFormat
     * @param strSport
     * @param strSportIconGreen
     * @param strSportThumb
     * @param strSportDescription
     */
    public Sport(String idSport, String strSport, String strFormat, String strSportThumb, String strSportIconGreen, String strSportDescription) {
        super();
        this.idSport = idSport;
        this.strSport = strSport;
        this.strFormat = strFormat;
        this.strSportThumb = strSportThumb;
        this.strSportIconGreen = strSportIconGreen;
        this.strSportDescription = strSportDescription;
    }

    public String getIdSport() {
        return idSport;
    }

    public void setIdSport(String idSport) {
        this.idSport = idSport;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrFormat() {
        return strFormat;
    }

    public void setStrFormat(String strFormat) {
        this.strFormat = strFormat;
    }

    public String getStrSportThumb() {
        return strSportThumb;
    }

    public void setStrSportThumb(String strSportThumb) {
        this.strSportThumb = strSportThumb;
    }

    public String getStrSportIconGreen() {
        return strSportIconGreen;
    }

    public void setStrSportIconGreen(String strSportIconGreen) {
        this.strSportIconGreen = strSportIconGreen;
    }

    public String getStrSportDescription() {
        return strSportDescription;
    }

    public void setStrSportDescription(String strSportDescription) {
        this.strSportDescription = strSportDescription;
    }

}
