
package com.example.retrofitrecycleview.models.health;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("nf_serving_size_qty")
    @Expose
    private Integer nfServingSizeQty;
    @SerializedName("nf_serving_size_unit")
    @Expose
    private String nfServingSizeUnit;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fields() {
    }

    /**
     * 
     * @param itemId
     * @param itemName
     * @param brandName
     * @param nfServingSizeQty
     * @param nfServingSizeUnit
     */
    public Fields(String itemId, String itemName, String brandName, Integer nfServingSizeQty, String nfServingSizeUnit) {
        super();
        this.itemId = itemId;
        this.itemName = itemName;
        this.brandName = brandName;
        this.nfServingSizeQty = nfServingSizeQty;
        this.nfServingSizeUnit = nfServingSizeUnit;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getNfServingSizeQty() {
        return nfServingSizeQty;
    }

    public void setNfServingSizeQty(Integer nfServingSizeQty) {
        this.nfServingSizeQty = nfServingSizeQty;
    }

    public String getNfServingSizeUnit() {
        return nfServingSizeUnit;
    }

    public void setNfServingSizeUnit(String nfServingSizeUnit) {
        this.nfServingSizeUnit = nfServingSizeUnit;
    }

}
