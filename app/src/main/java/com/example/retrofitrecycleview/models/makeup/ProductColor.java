
package com.example.retrofitrecycleview.models.makeup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class ProductColor {

    @SerializedName("hex_value")
    @Expose
    private String hexValue;
    @SerializedName("colour_name")
    @Expose
    private String colourName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductColor() {
    }

    /**
     * 
     * @param colourName
     * @param hexValue
     */
    public ProductColor(String hexValue, String colourName) {
        super();
        this.hexValue = hexValue;
        this.colourName = colourName;
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        this.hexValue = hexValue;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

}
