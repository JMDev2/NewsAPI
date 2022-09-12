
package com.example.retrofitrecycleview.models.health;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class HealthResponse {

    @SerializedName("total_hits")
    @Expose
    private Integer totalHits;
    @SerializedName("max_score")
    @Expose
    private Integer maxScore;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HealthResponse() {
    }

    /**
     * 
     * @param hits
     * @param totalHits
     * @param maxScore
     */
    public HealthResponse(Integer totalHits, Integer maxScore, List<Hit> hits) {
        super();
        this.totalHits = totalHits;
        this.maxScore = maxScore;
        this.hits = hits;
    }

    public Integer getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Integer totalHits) {
        this.totalHits = totalHits;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
