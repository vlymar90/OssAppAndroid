package com.example.ossapp.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.ossapp.R;
import com.example.ossapp.dto.StyleLevelDto;
import com.example.ossapp.dto.UserDto;
import com.example.ossapp.loginpages.LoginPageActivity;
import com.example.ossapp.requests.MyRetrofit;
import com.example.ossapp.requests.UserRequest;
import com.example.ossapp.util.StyleListSelect;
import java.util.ArrayList;

public class MasterLevelActivity extends AppCompatActivity {
    private ConstraintLayout selectTwo;
    private ConstraintLayout selectTree;
    private TextView labelOne;
    private TextView labelTwo;
    private TextView labelTree;
    private ArrayList<String> listStyle;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_level);
        button1 = (Button) findViewById(R.id.button12);
        button2 = (Button) findViewById(R.id.button13);
        button3 = (Button) findViewById(R.id.button14);
        button4 = (Button) findViewById(R.id.button15);
        button5 = (Button) findViewById(R.id.button16);
        button6 = (Button) findViewById(R.id.button17);
        button7 = (Button) findViewById(R.id.button18);
        button8 = (Button) findViewById(R.id.button19);
        button9 = (Button) findViewById(R.id.button20);
        button10 = (Button) findViewById(R.id.button21);
        button11 = (Button) findViewById(R.id.button22);
        button12 = (Button) findViewById(R.id.button23);
        selectTwo = (ConstraintLayout) findViewById(R.id.selecttwo);
        selectTree = (ConstraintLayout) findViewById(R.id.selecttree);
        labelOne = (TextView) findViewById(R.id.labelone);
        labelTwo = (TextView) findViewById(R.id.labeltwo);
        labelTree = (TextView) findViewById(R.id.labeltree);
        listStyle = StyleListSelect.listStyle;
        setCountLayout();
    }

    public void nextActivity(View view) {
        UserRequest userRequest = MyRetrofit.getInstance().create(UserRequest.class);
        userRequest.saveProfile(UserDto.getInstance());
        Intent loginPage = new Intent(this, LoginPageActivity.class);
        startActivity(loginPage);
    }

    private void setCountLayout() {
        switch (listStyle.size()) {
            case 1:
                labelOne.setText(listStyle.get(0));
                selectTwo.setVisibility(View.GONE);
                selectTree.setVisibility(View.GONE);
                break;
            case 2:
                labelOne.setText(listStyle.get(0));
                labelTwo.setText(listStyle.get(1));
                selectTree.setVisibility(View.GONE);
                break;
            case 3:
                labelOne.setText(listStyle.get(0));
                labelTwo.setText(listStyle.get(1));
                labelTree.setText(listStyle.get(2));
        }
    }

    public void selectLevelStyleOne(View view) {
        int styleNumber = StyleListSelect.getNumberStyle(listStyle.get(0));
        Button[] buttonsOne = selectGroupButton(1);
        selectLevel(view, buttonsOne, styleNumber);
    }

    public void selectLevelStyleTwo(View view) {
        int styleNumber = StyleListSelect.getNumberStyle(listStyle.get(1));
        Button[] buttonsTwo = selectGroupButton(2);
        selectLevel(view, buttonsTwo, styleNumber);
    }

    public void selectLevelStyleThree(View view) {
        int styleNumber = StyleListSelect.getNumberStyle(listStyle.get(2));
        Button[] buttonsThree = selectGroupButton(3);
        selectLevel(view, buttonsThree, styleNumber);
    }

    private void selectLevel(View view, Button[] buttons, int numberStyle) {
        Button button = (Button) view;
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().equals(button.getText())) {
                int level = getNumberLevel(button.getText().toString());
                UserDto.getInstance().getStyleLevelList().add(new StyleLevelDto(numberStyle, level));
                button.setBackgroundColor(Color.BLUE);
                button.setTextColor(Color.WHITE);
            }
            else {
                buttons[i].setTextColor(Color.BLACK);
                buttons[i].setBackgroundColor(Color.WHITE);
            }
        }
    }

    private Button[] selectGroupButton(int group) {
        if (group == 1) {
            return new Button[]{button1, button2, button3, button4};
        }

        if (group == 2) {
            return new Button[]{button5, button6, button7, button8};
        }
        if (group == 3) {
            return new Button[]{button9, button10, button11, button12};
        }
        return null;
    }

    private Integer getNumberLevel(String nameLevel) {
        switch (nameLevel) {
            case "Начинающий":
                return 1;
            case "Средний":
                return 2;
            case "Продвинутый":
                return 3;
            case "Профессиональный":
                return 4;
        }
        return 0;
    }
}
