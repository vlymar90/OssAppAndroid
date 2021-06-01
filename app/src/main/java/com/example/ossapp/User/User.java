package com.example.ossapp.User;

import java.util.HashMap;
import java.util.Map;



/*Этот класс отвечает за сбор данных о пользователе.
* Так как, на устройстве будит один клиент, сделал
* класс сингелтоном. Так же будит удобно тащить пользователя
* через страницы, чтобы добавлять данные в его аккаунт
* Класс нужно будит доработать, по необхадимости добавить нужные поля*/



//import javax.annotation.PostConstruct;

/*Этот класс отвечает за сбор данных о пользователе.
 * Так как, на устройстве будит один клиент, сделал
 * класс сингелтоном. Так же будит удобно тащить пользователя
 * через страницы, чтобы добавлять данные в его аккаунт
 * Класс нужно будит доработать, по необхадимости добавить нужные поля*/

public class User {
    public static User instance;
    private String userPhone;
    private String userName;
    private int userAge;
    private int userWeight;
    private int sexUser;
    private long city;
    private String loginTelegram;

    private Map<Integer, Integer> userStyleList = new HashMap<>();


    public User(){};

    public static User getInstance() {
        if(instance == null) {
            instance = new User();
            return instance;
        }
        return instance;
    }

    public static void setNameAgeTelegram(String name,Integer age, String telegram) {
        instance.setUserName(name);
        instance.setUserAge(age);
        instance.setLoginTelegram(telegram);
    }

    public boolean fullField() {
        if(!userName.isEmpty() && userAge !=0 && sexUser !=0
        && userWeight !=0) {
            return true;
        }
        return false;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public int getUserWeight() {
        return userWeight;
    }

    public int getSexUser() {
        return sexUser;
    }

    public long getCity() {
        return city;
    }

    public Map<Integer, Integer> getUserStyleList() {
        return userStyleList;
    }

    public String getLoginTelegram() {
        return loginTelegram;
    }

    public void setCity(long city) {
        this.city = city;
    }

    public static void setInstance(User instance) {
        User.instance = instance;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setUserWeight(int userWeight) {
        this.userWeight = userWeight;
    }

    public void setSexUser(int sexUser) {
        this.sexUser = sexUser;
    }

    public void setLoginTelegram(String loginTelegram) {
        this.loginTelegram = loginTelegram;
    }
}
