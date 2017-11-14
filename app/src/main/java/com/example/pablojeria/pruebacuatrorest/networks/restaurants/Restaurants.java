package com.example.pablojeria.pruebacuatrorest.networks.restaurants;

import com.example.pablojeria.pruebacuatrorest.models.Restaurant;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by pablojeria on 12-11-17.
 */

public interface Restaurants {

    @GET("collections")
    Call<Restaurant[]> get(@QueryMap Map<String, String> queryMap);

}
