package com.eekhout.reporteer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Alexander on 27-06-2016.
 */

public class Photo {
    @JsonIgnore
    private String id;
    @JsonIgnore
    private boolean publishedByMe;

    private String url;
    private String email;
    private String descripcion;
    private double latitude;
    private double longitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPublishedByMe() {
        return publishedByMe;
    }

    public void setPublishedByMe(boolean publishedByMe) {
        this.publishedByMe = publishedByMe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLatitutde() {
        return latitude;
    }

    public void setLatitutde(double latitutde) {
        this.latitude = latitutde;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
