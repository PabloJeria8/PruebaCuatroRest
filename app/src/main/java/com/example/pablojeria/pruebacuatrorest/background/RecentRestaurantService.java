package com.example.pablojeria.pruebacuatrorest.background;

public class RecentRestaurantService {


//    private static final String ACTION_RECENT_RESTAURANTS = "com.example.pablojeria.pruebacuatrorest.background.action.ACTION_RECENT_RESTAURANTS";
//    public static final String RESTAURANTS_FINISHED = "com.example.pablojeria.pruebacuatrorest.background.RESTAURANTS_FINISHED";
//
//
//    public RecentRestaurantService() {
//        super("RecentRestaurantService");
//    }
//
//
//    public static void startActionRecentRestaurants(Context context) {
//        Intent intent = new Intent(context, RecentRestaurantService.class);
//        intent.setAction(ACTION_RECENT_RESTAURANTS);
//        context.startService(intent);
//    }
//
//    @Override
//    protected void onHandleIntent(Intent intent) {
//        if (intent != null) {
//            final String action = intent.getAction();
//            if (ACTION_RECENT_RESTAURANTS.equals(action)) {
//                fetchRestaurants();
//            }
//        }
//    }
//
//    private void fetchRestaurants() {
//        Map<String, String> queryMap = new HashMap<>();
//        queryMap.put("count", "30");
//        queryMap.put("city_id", "83");
//        queryMap.put("lat", "-33.440914");
//        queryMap.put("lon", "-70.653654");
//
//        new FetchRestaurants(3).execute(queryMap);
//
//    }
//
//    private class FetchRestaurants extends GetDataRestaurants {
//
//        public FetchRestaurants(int additionalPages) {
//            super(additionalPages);
//        }
//
//        @Override
//        protected void onPostExecute(Integer integer) {
//            super.onPostExecute(integer);
//
//            Intent intent =  new Intent();
//            intent.setAction(RESTAURANTS_FINISHED);
//            LocalBroadcastManager.getInstance(RecentRestaurantService.this).sendBroadcast(intent);
//
//        }
//    }


}
