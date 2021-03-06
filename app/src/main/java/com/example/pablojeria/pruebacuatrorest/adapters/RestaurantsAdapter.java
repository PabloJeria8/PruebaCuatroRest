package com.example.pablojeria.pruebacuatrorest.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pablojeria.pruebacuatrorest.R;
import com.example.pablojeria.pruebacuatrorest.data.RestaurantQueries;
import com.example.pablojeria.pruebacuatrorest.models.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablojeria on 13-11-17.
 */

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.ViewHolder> {

    // private List<Restaurant> restaurantslist = new RestaurantQueries().all();
    private List<Restaurant> restaurantslist = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Restaurant restaurant = restaurantslist.get(position);
        //final Context context = holder.itemView.getContext();
        Picasso.with(holder.itemView.getContext()).load(restaurant.getCollections([get]).getImage_url()).centerCrop().fit().into(holder.photo);
        //holder.titletextView.setText(restaurant.getTitle());
        //holder.descriptiontextView.setText(restaurant.getDescription());

//        holder.twitter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = restaurantslist.get(holder.getAdapterPosition()).getTwitter();
//                webIntent(url, context);
//            }
//        });


    }

    private void webIntent(String url, Context context) {
        if (url != null && url.trim().length() > 0) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
        }
    }

    public void update(List<Restaurant> restaurants) {
        restaurantslist.addAll(restaurants);
        //restaurants.clear();
        //restaurants.addAll(new RestaurantQueries().all());
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return restaurantslist.size();
    }

    public void find(String name) {
        restaurantslist.clear();
        restaurantslist.addAll(new RestaurantQueries().findByName(name));
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView photo;
        private TextView titletextView;
        private TextView descriptiontextView;

        public ViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.restaurantIv);
//            titletextView = (TextView) itemView.findViewById(R.id.titleTv);
//            descriptiontextView = (TextView) itemView.findViewById(R.id.descriptionTv);
        }

    }

}