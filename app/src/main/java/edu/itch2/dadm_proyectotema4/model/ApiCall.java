package edu.itch2.dadm_proyectotema4.model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

    /**
     * It returns a Call object that can be used to make a network request to the specified URL
     * 
     * @return An ArrayList of Model objects.
     */
    @GET("posts")
    Call<ArrayList<Model>> callModel();
}
