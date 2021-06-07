package com.example.ossapp.dto;

import java.util.List;

/*Этот класс отвечает за сбор данных о пользователе.
 * Так как, на устройстве будит один клиент, сделал
 * класс сингелтоном. Так же будит удобно тащить пользователя
 * через страницы, чтобы добавлять данные в его аккаунт
 * Класс нужно будит доработать, по необхадимости добавить нужные поля*/

public class UserDto {
    public static UserDto instance;
    private String email;
    private String password;
    private String name;
    private String nickTelegram;
    private String phone;
    private int weight;
    private int sex;
    private int userAge;
    private long cityId;
    private String about;
    private List<StyleLevelDto> styleLevelList;





    public UserDto(){};

    public static UserDto getInstance() {
        if(instance == null) {
            instance = new UserDto();
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    public long getCityId() {
        return cityId;
    }

    public String getAbout() {
        return about;
    }

    public List<StyleLevelDto> getStyleLevelList() {
        return styleLevelList;
    }

    public static void setInstance(UserDto instance) {
        UserDto.instance = instance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setCity(long city) {
        this.cityId = city;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setStyleLevelList(List<StyleLevelDto> styleLevelList) {
        this.styleLevelList = styleLevelList;
    }
}
