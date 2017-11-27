package com.example.tashf.myapplication128;

/**
 * Created by tashf on 11/26/2017.
 */

public class Infos {
    private double latitude,longitude;
    private int check_alive;
    private String id;
    public Infos()
    {

    }

    public Infos(String id,double latitude, double longitude, int check_alive) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.check_alive = check_alive;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getCheck_alive() {
        return check_alive;
    }

    public void setCheck_alive(int check_alive) {
        this.check_alive = check_alive;
    }
}
