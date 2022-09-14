
package com.example.retrofitrecycleview.models.sports;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Sportsresponse {

    @SerializedName("sports")
    @Expose
    private List<Sport> sports = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sportsresponse() {
    }

    /**
     * 
     * @param sports
     */
    public Sportsresponse(List<Sport> sports) {
        super();
        this.sports = sports;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

}
