package com.example.ossapp.util;

import android.app.Activity;
import android.widget.Button;

public class UtilButton {
    private UtilButton() {
    }

    public static void setButtonText(Button button) {
        button.setEnabled(false);
//        (new Thread(() -> {
//            int time = 59;
//            int x = 0;
//            while (x < time) {
//                button.setText(String.format("Запросить повторно через 00:%d", time));
//                try {
//                    Thread.sleep(1000000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                time--;
//                if(time == 1) {
//                    button.setEnabled(true);
//                    break;
//                }
//            }
//        }
//        ).run());

    }
}
