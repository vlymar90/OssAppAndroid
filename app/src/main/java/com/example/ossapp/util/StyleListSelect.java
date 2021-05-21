package com.example.ossapp.util;

import java.util.ArrayList;

public class StyleListSelect {
    public static ArrayList<String> listStyle = new ArrayList<>();
    private StyleListSelect() {}
    public static Integer getNumberStyle(String nameStyle) {
        switch (nameStyle) {
            case "ММА" : return 1;
            case "БЖЖ" : return 2;
            case "Кикбоксинг" : return 3;
            case "Карате" : return 4;
            case "Самбо" : return 5;
            case "Тхэквондо" : return 6;
            case "Дзюдо" : return  7;
            case "Вольная борьба" : return  8;
            case "Грэпплинг" : return 9;
        }
        return 0;
    }
}
