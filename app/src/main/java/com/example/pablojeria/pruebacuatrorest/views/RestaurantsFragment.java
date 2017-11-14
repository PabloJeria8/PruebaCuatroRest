package com.example.pablojeria.pruebacuatrorest.views;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pablojeria.pruebacuatrorest.R;
import com.example.pablojeria.pruebacuatrorest.adapters.RestaurantsAdapter;
import com.example.pablojeria.pruebacuatrorest.networks.GetRestaurants;

import java.util.HashMap;
import java.util.Map;

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

        refreshLayout =  view.findViewById(R.id.reloadSrl);
        RecyclerView recyclerView = view.findViewById(R.id.restaurantsRv);
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new DevelopersAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int position = linearLayoutManager.findLastVisibleItemPosition();
                int total = linearLayoutManager.getItemCount();

                if (total-10 < position)
                {
                    if (!pendingRequest)
                    {
                        Map<String, String> map = new HashMap<String, String>();
                        String currentPage = String.valueOf((total/10)+1);
                        map.put("page",currentPage);
                        new ScrollRequest(4).execute(map);
                    }
                }

        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pendingRequest = false;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                        adapter.update();
                    }
                }, 800);
            }
        });

    }


    public void update(String name) {
        pendingRequest = true;
        adapter.find(name);
    }

    private class ScrollRequest extends GetRestaurants
    {

        public ScrollRequest(int additionalPages) {
            super(additionalPages);
        }

        @Override
        protected void onPreExecute() {
            pendingRequest=true;
            refreshLayout.setRefreshing(true);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            pendingRequest=false;
            adapter.update();;
            refreshLayout.setRefreshing(false);
        }
    }
}