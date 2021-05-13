package com.example.ossapp.User;

import java.util.HashMap;
import java.util.Map;
//import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
/*Этот класс отвечает за сбор данных о пользователе.
 * Так как, на устройстве будит один клиент, сделал
 * класс сингелтоном. Так же будит удобно тащить пользователя
 * через страницы, чтобы добавлять данные в его аккаунт
 * Класс нужно будит доработать, по необхадимости добавить нужные поля*/
@Getter
@Setter
public class User {
    public static User instance;
    private String userPhone;
    private String userName;
    private int userAge;
    private int userWeight;
    private int sexUser;
    private Map<String, String> userStyleList;

//    @PostConstruct
    private void initMap() {
        userStyleList = new HashMap<>();
    }

    private User(){};

    public static User getInstance() {
        if(instance == null) {
            instance = new User();
            return instance;
        }
        return instance;
    }
}
