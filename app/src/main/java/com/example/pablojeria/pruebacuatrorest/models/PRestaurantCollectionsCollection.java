package com.example.pablojeria.pruebacuatrorest.models;

public class PRestaurantCollectionsCollection {
    private int collection_id;
    private int res_count;
    private String image_url;
    private String share_url;
    private String description;
    private String title;
    private String url;

    public int getCollection_id() {
        return this.collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }

    public int getRes_count() {
        return this.res_count;
    }

    public void setRes_count(int res_count) {
        this.res_count = res_count;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getShare_url() {
        return this.share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
