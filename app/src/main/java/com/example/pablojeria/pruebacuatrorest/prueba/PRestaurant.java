package com.example.pablojeria.pruebacuatrorest.prueba;

import com.example.pablojeria.pruebacuatrorest.models.PRestaurantCollections;

public class PRestaurant {
    private int has_total;
    private PRestaurantCollections[] collections;
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
}
