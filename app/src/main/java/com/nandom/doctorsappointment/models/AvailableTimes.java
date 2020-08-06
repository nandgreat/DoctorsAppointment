package com.nandom.doctorsappointment.models;

import java.util.List;

public class AvailableTimes {

    private String timeTitle;
    private String timeInterval;
    private int timeImage;
    private List<String> myAvailableTimes;

    public AvailableTimes(String timeTitle, String timeInterval, int timeImage, List<String> myAvailableTimes) {
        this.timeTitle = timeTitle;
        this.timeInterval = timeInterval;
        this.timeImage = timeImage;
        this.myAvailableTimes = myAvailableTimes;
    }

    public String getTimeTitle() {
        return timeTitle;
    }

    public void setTimeTitle(String timeTitle) {
        this.timeTitle = timeTitle;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getTimeImage() {
        return timeImage;
    }

    public void setTimeImage(int timeImage) {
        this.timeImage = timeImage;
    }

    public List<String> getMyAvailableTimes() {
        return myAvailableTimes;
    }

    public void setMyAvailableTimes(List<String> myAvailableTimes) {
        this.myAvailableTimes = myAvailableTimes;
    }
}
