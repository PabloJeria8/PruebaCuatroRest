package com.example.pablojeria.pruebacuatrorest.networks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.pablojeria.pruebacuatrorest.models.Restaurant;
import com.example.pablojeria.pruebacuatrorest.networks.restaurants.RestaurantInterceptor;
import com.example.pablojeria.pruebacuatrorest.networks.restaurants.Restaurants;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by pablojeria on 12-11-17.
 */

public class GetRestaurants extends AsyncTask<Map<String, String>, Integer, Integer> {

    private int additionalPages;
    private Map<String, String> queryMap;
    private int result;
    private final Restaurants request = new RestaurantInterceptor().get();

    public GetRestaurants(int additionalPages) {
        this.additionalPages = additionalPages;
    }

    @Override
    protected Integer doInBackground(Map<String, String>[] maps) {

        queryMap = maps[0];

        if (additionalPages < 0)
        {
            while (200 == connect())
            {
                //increasePage();
            }

        }else
        {
            while (additionalPages >= 0)
            {
                additionalPages--;
                connect();
                //increasePage();
            }
        }
        return null;
    }

/*    private void increasePage()
    {
        int page = Integer.parseInt(queryMap.get("count"));
        page++;
        queryMap.put("count", String.valueOf(page));

    }*/


    private int connect()
    {
        int code = 666;

        Call<Restaurant[]> call = request.get(queryMap);

        try {
            Response<Restaurant[]> response =  call.execute();

            code = response.code();

            Log.d("PJMeee", String.valueOf(code));

            if (200 == code && response.isSuccessful())
            {
                Restaurant[] restaurants = response.body();

                if (restaurants != null && restaurants.length > 0)
                {

                   for (Restaurant servRest: restaurants
                           ) {
                      List<Restaurant> localRests= Restaurant.find(Restaurant.class, "serverId = ?", String.valueOf(servRest.getId()));

                       if (localRests != null && localRests.size() > 0)
                       {
                           Restaurant local = localRests.get(0);
                           local.setImage_url(servRest.getImage_url());
                           local.setUrl(servRest.getUrl());
                           local.setShare_url(servRest.getShare_url());
                           local.setDescription(servRest.getDescription());
                           local.setTitle(servRest.getTitle());
                           local.save();
                      }else
                        {
                          servRest.create();
                       }
                   }
                } else {
                    code = 23;
                }
            }else
            {
                code = 777;
            }

        } catch (IOException e) {
            e.printStackTrace();
            code = 888;
        }
        result =  code;
        Log.d("REQUEST", String.valueOf(result));
        return result;

    }






}
