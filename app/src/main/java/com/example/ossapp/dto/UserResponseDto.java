package com.example.ossapp.dto;

import java.io.Serializable;
import java.util.List;

//Этот класс нужен для запросов поиска бойцов

public class UserResponseDto implements Serializable {
    public static UserResponseDto instance;
    private String name;
    private String nickTelegram;
    private String phone;
    private String weight;
    private String sex;
    private int userAge;
    private String city;
    private String about;
    private String style; // пока в стринге
    private String level; // пока в стринге


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
        if(!name.isEmpty() && userAge !=0 && sex !=null
                && weight !=null) {
            return true;
        }
        return false;
    }

    public String getLevel() {
        return level;
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

    public String getUserWeight() {
        return weight;
    }

    public String getSexUser() {
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

    public String getStyle() {
        return style;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public void setUserWeight(String userWeight) {
        this.weight = userWeight;
    }

    public void setSexUser(String sexUser) {
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

    public void setStyle(String style) {
        this.style = style;
    }
}
