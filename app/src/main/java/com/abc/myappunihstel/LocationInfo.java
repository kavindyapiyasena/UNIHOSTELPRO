package com.abc.myappunihstel;

public class LocationInfo {
    private final String name;
    private final String status;
    private final String closingTime;
    private final String phone;
    private final String address;
    private final double latitude;
    private final double longitude;

    public LocationInfo(String name, String status, String closingTime, String phone, String address, double latitude, double longitude) {
        this.name = name;
        this.status = status;
        this.closingTime = closingTime;
        this.phone = phone;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() { return name; }
    public String getStatus() { return status; }
    public String getClosingTime() { return closingTime; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}
