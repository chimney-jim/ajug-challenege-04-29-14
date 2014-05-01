package com.example.AJUG_challenge.activities;

import android.os.AsyncTask;
import android.util.Log;
import com.example.AJUG_challenge.models.Movie;
import com.example.AJUG_challenge.models.SearchResponse;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 * User: jfitzgerald
 * Date: 4/30/14
 * Time: 8:26 PM
 */
public class RetrieveTomatoData extends AsyncTask<String, Void, SearchResponse> {

    @Override
    protected SearchResponse doInBackground(String... urls) {
        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet getRequest = new HttpGet(urls[0]);

        try {
            HttpResponse getResponse = client.execute(getRequest);
            final int statusCode = getResponse.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {
                Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL " + urls[0]);
                return null;
            }

            HttpEntity getResponseEntity = getResponse.getEntity();

            Reader reader = new InputStreamReader(getResponseEntity.getContent());

            Gson gson = new Gson();

            SearchResponse response = gson.fromJson(reader, SearchResponse.class);

            return response;

        }
        catch (IOException e) {
            getRequest.abort();
            Log.w(getClass().getSimpleName(), "Error for URL " + urls[0], e);
        }

        return null;
    }
}
