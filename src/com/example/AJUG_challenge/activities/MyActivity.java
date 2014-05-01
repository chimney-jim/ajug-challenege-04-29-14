package com.example.AJUG_challenge.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.AJUG_challenge.R;
import com.example.AJUG_challenge.models.Movie;
import com.example.AJUG_challenge.models.SearchResponse;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    String boxOfficeMoviesUrl = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=mjjcys9prmxtmksvg4cb3mvh";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        RetrieveTomatoData retrieveTomatoData = new RetrieveTomatoData();

        SearchResponse response = null;

        try {
            response = retrieveTomatoData.execute(boxOfficeMoviesUrl).get();
        }
        catch (Exception e) {
            Log.w(getClass().getSimpleName(), e);
        }

        for(Movie movie : response.movies) {
            Toast.makeText(this, movie.title, Toast.LENGTH_SHORT).show();
        }
    }
}
