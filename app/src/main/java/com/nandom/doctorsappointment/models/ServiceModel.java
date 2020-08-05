package com.nandom.doctorsappointment.models;

public class ServiceModel {
    private int thumbnail;
    private String serviceName;

    public ServiceModel(int thumbnail, String serviceName) {
        this.thumbnail = thumbnail;
        this.serviceName = serviceName;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
