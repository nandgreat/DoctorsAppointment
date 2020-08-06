package com.nandom.doctorsappointment.models;

public class Doctors {

    private String doctorName;
    private String specialty;
    private String language;
    private int doctorImage;
    private String amount;
    private String time;

    public Doctors(String doctorName, String specialty, String language, int doctorImage, String amount) {
        this.doctorName = doctorName;
        this.specialty = specialty;
        this.language = language;
        this.doctorImage = doctorImage;
        this.amount = amount;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(int doctorImage) {
        this.doctorImage = doctorImage;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
