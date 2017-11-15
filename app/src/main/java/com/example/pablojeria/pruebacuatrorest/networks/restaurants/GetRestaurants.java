package com.example.pablojeria.pruebacuatrorest.networks.restaurants;

import com.example.pablojeria.pruebacuatrorest.models.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pablojeria on 12-11-17.
 */

public interface GetRestaurants {

    @GET("collections?city_id=83&lat=-33.440914&lon=-70.653654&count=10")
    Call<List<Restaurant>> get(@Query("count") int count);


   // @GET("collections?city_id=83&lat=-33.440914&lon=-70.653654&count=30")
    //Call<Restaurant[]> get(@QueryMap Map<String, String> queryMap);
    //Call<Restaurant[]> get(@QueryMap Map<String, String> queryMap);


}
