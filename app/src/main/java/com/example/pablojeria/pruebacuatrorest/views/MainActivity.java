package com.example.pablojeria.pruebacuatrorest.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.pablojeria.pruebacuatrorest.R;
import com.example.pablojeria.pruebacuatrorest.models.Restaurant;
import com.example.pablojeria.pruebacuatrorest.networks.GetDataRestaurants;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Test().execute();

    }

    private class Test extends GetDataRestaurants {

        @Override
        protected void onPostExecute(List<Restaurant> restaurants) {

            super.onPostExecute(restaurants);

            Log.d("PJM1", String.valueOf(restaurants));
        }
    }
}
