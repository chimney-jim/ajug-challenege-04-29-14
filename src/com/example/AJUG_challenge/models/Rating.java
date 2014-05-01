package com.example.AJUG_challenge.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created with IntelliJ IDEA.
 * User: jfitzgerald
 * Date: 4/30/14
 * Time: 7:53 PM
 */
public class Rating {

    @SerializedName("critics_rating")
    public String criticsRating;

    @SerializedName("critics_score")
    public Integer criticsScore;

    @SerializedName("audience_rating")
    public String audienceRating;

    @SerializedName("audience_score")
    public Integer audienceScore;
}
