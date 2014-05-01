package com.example.AJUG_challenge.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jfitzgerald
 * Date: 4/30/14
 * Time: 7:36 PM
 */
public class Movie {

    public String id;
    public String title;
    public Integer year;

    @SerializedName("mpaa_rating")
    public String mpaaRating;

    public Integer runtime;

    @SerializedName("critics_consensus")
    public String criticsConsensus;

    @SerializedName("release_dates")
    public ReleaseDate releaseDates;

    public Rating ratings;
    public String synopsis;
    public Poster posters;

    @SerializedName("abridged_cast")
    public List<CastMember> abridgedCast;

    @SerializedName("alternate_ids")
    public AlternateId alternateIds;
    public Link links;
}
