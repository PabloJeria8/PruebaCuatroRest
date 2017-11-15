package com.example.pablojeria.pruebacuatrorest.views;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pablojeria.pruebacuatrorest.R;
import com.example.pablojeria.pruebacuatrorest.adapters.RestaurantsAdapter;
import com.example.pablojeria.pruebacuatrorest.models.Restaurant;
import com.example.pablojeria.pruebacuatrorest.networks.GetDataRestaurants;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    private SwipeRefreshLayout refreshLayout;
    private RestaurantsAdapter adapter;
    private boolean pendingRequest =  false;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurants, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.reloadSrl);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.restaurantsRv);
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RestaurantsAdapter();
        recyclerView.setAdapter(adapter);

    }


    public void update(String name) {
        pendingRequest = true;
        adapter.find(name);
    }

    private class ScrollRequest extends GetDataRestaurants
    {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setCancelable(false);
            progressDialog.show();
//            pendingRequest=true;
//            refreshLayout.setRefreshing(true);
        }

        @Override
        protected void onPostExecute(List<Restaurant> restaurants) {
            adapter.update(restaurants);

            if(progressDialog != null && progressDialog.isShowing())
            {
                progressDialog.dismiss();
            }

            //super.onPostExecute(restaurants);
        }

//        @Override
//        protected void onPostExecute(Integer integer) {
//            pendingRequest=false;
//            adapter.update();
//            refreshLayout.setRefreshing(false);
//        }
    }
}