package com.akanksha.demoThymeleaf.model;

import java.util.List;

public class Student {

    private  String firstName;

    private String lastName;

    private String country;


    private String favoriteLanguage;

    private List<String> favoriteSystems;

    public  Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }


    public List<String> getFavoriteSystem() {
        return favoriteSystems;
    }

    public void setFavoriteSystem(List<String> favoriteSystem) {
        this.favoriteSystems = favoriteSystem;
    }
}
