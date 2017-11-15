package com.example.pablojeria.pruebacuatrorest.networks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.pablojeria.pruebacuatrorest.models.Restaurant;
import com.example.pablojeria.pruebacuatrorest.networks.restaurants.GetRestaurants;
import com.example.pablojeria.pruebacuatrorest.networks.restaurants.RestaurantInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by pablojeria on 12-11-17.
 */

public class GetDataRestaurants extends AsyncTask<Void, Void, List<Restaurant>> {

    private int result;
    private final com.example.pablojeria.pruebacuatrorest.networks.restaurants.GetRestaurants request = new RestaurantInterceptor().get();


//    @Override
//    protected Integer doInBackground(Map<String, String>[] maps) {
//
//        queryMap = maps[0];
//
//        if (additionalPages < 0)
//        {
//            while (200 == connect())
//            {
//                //increasePage();
//            }
//
//        }else
//        {
//            while (additionalPages >= 0)
//            {
//                additionalPages--;
//                connect();
//                //increasePage();
//            }
//        }
//        return null;
//    }

/*    private void increasePage()
    {
        int page = Integer.parseInt(queryMap.get("count"));
        page++;
        queryMap.put("count", String.valueOf(page));

    }*/


//    private int connect()
//    {
//        int code = 666;
//
//        Call<Restaurant[]> call = request.get(queryMap);
//
//        try {
//            Response<Restaurant[]> response =  call.execute();
//
//            code = response.code();
//
//            Log.d("PJMeee", String.valueOf(code));
//
//            if (200 == code && response.isSuccessful())
//            {
//                Restaurant[] restaurants = response.body();
//
//                if (restaurants != null && restaurants.length > 0)
//                {
//
//                   for (Restaurant servRest: restaurants
//                           ) {
//                      List<Restaurant> localRests= Restaurant.find(Restaurant.class, "serverId = ?", String.valueOf(servRest.getId()));
//
//                       if (localRests != null && localRests.size() > 0)
//                       {
//                           Restaurant local = localRests.get(0);
//                           local.setImage_url(servRest.getImage_url());
//                           local.setUrl(servRest.getUrl());
//                           local.setShare_url(servRest.getShare_url());
//                           local.setDescription(servRest.getDescription());
//                           local.setTitle(servRest.getTitle());
//                           local.save();
//                      }else
//                        {
//                          servRest.create();
//                       }
//                   }
//                } else {
//                    code = 23;
//                }
//            }else
//            {
//                code = 777;
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            code = 888;
//        }
//        result =  code;
//        Log.d("REQUEST", String.valueOf(result));
//        return result;
//
//    }


    @Override
    protected List<Restaurant> doInBackground(Void... voids) {

        GetRestaurants request = (GetRestaurants) new RestaurantInterceptor().get();

            Call<List<Restaurant>> call = request.get(10);
            List<Restaurant> restaurantlist = new ArrayList<>();

        try {



            Response<List<Restaurant>> response = call.execute();


            if (200 == response.code() && response.isSuccessful())
            {

                if (response.body().size()>0)
                {
                    restaurantlist = response.body();

                    Log.d("LisRest",restaurantlist.toString());

                    if (restaurantlist.size()>0)
                    {
                        for (Restaurant restaurant : restaurantlist)
                        {
                           // Log.d("Pjmurl", restaurant.getUrl());
                        }
                    }

                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return restaurantlist;
    }
}
