package com.example.pablojeria.pruebacuatrorest.models;

public class Restaurant extends SugarBase {

    private int has_total;
    private PRestaurantCollections[] collections;
    private PRestaurantCollectionsCollection pRestaurantCollectionsCollection;
    private String share_url;
    private int has_more;
    private String display_text;

    public int getHas_total() {
        return this.has_total;
    }

    public void setHas_total(int has_total) {
        this.has_total = has_total;
    }

    public PRestaurantCollections[] getCollections() {
        return this.collections;
    }

    public void setCollections(PRestaurantCollections[] collections) {
        this.collections = collections;
    }

    public String getShare_url() {
        return this.share_url;
    }

    public PRestaurantCollectionsCollection getpRestaurantCollectionsCollection() {
        return pRestaurantCollectionsCollection;
    }

    public void setpRestaurantCollectionsCollection(PRestaurantCollectionsCollection pRestaurantCollectionsCollection) {
        this.pRestaurantCollectionsCollection = pRestaurantCollectionsCollection;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getHas_more() {
        return this.has_more;
    }

    public void setHas_more(int has_more) {
        this.has_more = has_more;
    }

    public String getDisplay_text() {
        return this.display_text;
    }

    public void setDisplay_text(String display_text) {
        this.display_text = display_text;
    }


//    private int collection_id, res_count;
//    private String image_url, share_url, description, title, url;
//
//    public Restaurant() {
//    }
//
//    public int getCollection_id() {
//        return this.collection_id;
//    }
//
//    public void setCollection_id(int collection_id) {
//        this.collection_id = collection_id;
//    }
//
//    public int getRes_count() {
//        return this.res_count;
//    }
//
//    public void setRes_count(int res_count) {
//        this.res_count = res_count;
//    }
//
//    public String getImage_url() {
//        return this.image_url;
//    }
//
//    public void setImage_url(String image_url) {
//        this.image_url = image_url;
//    }
//
//    public String getShare_url() {
//        return this.share_url;
//    }
//
//    public void setShare_url(String share_url) {
//        this.share_url = share_url;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getUrl() {
//        return this.url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }

}
