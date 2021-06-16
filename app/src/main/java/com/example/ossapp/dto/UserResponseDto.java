package com.example.ossapp.dto;

import java.io.Serializable;
import java.util.List;

//Этот класс нужен для запросов поиска бойцов

public class UserResponseDto implements Serializable {
    public static UserResponseDto instance;
    private String name;
    private String nickTelegram;
    private String phone;
    private int weight;
    private int sex;
    private int userAge;
    private String city;
    private String about;
    private List<Long> styleLevelList;

    public UserResponseDto(){};

    public static UserResponseDto getInstance() {
        if(instance == null) {
            instance = new UserResponseDto();
            return instance;
        }
        return instance;
    }

    public static void setNameAgeTelegram(String name,Integer age, String telegram) {
        instance.setName(name);
        instance.setUserAge(age);
        instance.setLoginTelegram(telegram);
    }

    public boolean fullField() {
        if(!name.isEmpty() && userAge !=0 && sex !=0
                && weight !=0) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getLoginTelegram() {
        return nickTelegram;
    }

    public String getPhone() {
        return phone;
    }

    public int getUserWeight() {
        return weight;
    }

    public int getSexUser() {
        return sex;
    }

    public int getUserAge() {
        return userAge;
    }

    public String getCity() {
        return city;
    }

    public String getAbout() {
        return about;
    }

    public List<Long> getStyleLevelList() {
        return styleLevelList;
    }

    public static void setInstance(UserDto instance) {
        UserDto.instance = instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoginTelegram(String loginTelegram) {
        this.nickTelegram = loginTelegram;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserWeight(int userWeight) {
        this.weight = userWeight;
    }

    public void setSexUser(int sexUser) {
        this.sex = sexUser;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setStyleLevelList(List<Long> styleLevelList) {
        this.styleLevelList = styleLevelList;
    }
}
