package com.example.ossapp.util;

import com.example.ossapp.User.User;

public class UtilSelectStyle {
    private UtilSelectStyle() {
    }
    /*Метод добавляет стили в мап пользователя*/
    public static boolean selectStyle(String style) {
        User user = User.getInstance();
        if(!user.getUserStyleList().containsKey(style)) {
            user.getUserStyleList().put(style, null);
            return true;
        }
        else {
            user.getUserStyleList().remove(style);
            return false;
        }
    }
}
