package com.example.pablojeria.pruebacuatrorest.data;

import com.example.pablojeria.pruebacuatrorest.models.Restaurant;

import java.util.List;

/**
 * Created by pablojeria on 13-11-17.
 */

public class RestaurantQueries {

    public List<Restaurant> all()
    {
        return Restaurant.listAll(Restaurant.class);
    }

    public List<Restaurant> findByName(String name)
    {
        String query = "name LIKE ?";
        String argument = "%"+name+"%";
        return Restaurant.find(Restaurant.class,query,argument);
    }
}
