package com.example.ossapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AvatarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        TextView installAvatar = findViewById(R.id.installAvatar);
        Button next = (Button) findViewById(R.id.next);
        Button skip = (Button) findViewById(R.id.skip);
        ImageButton avatar = (ImageButton) findViewById(R.id.avatar);

        Intent fromChoosingAvatar = getIntent();

        if (fromChoosingAvatar.hasExtra("picture")) {
            byte [] bytes = fromChoosingAvatar.getByteArrayExtra("picture");
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            avatar.setImageBitmap(bitmap);
        }

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = AvatarActivity.this;

                String nextActivity = "choose your avatar";
                Toast.makeText(context, nextActivity, Toast.LENGTH_LONG).show();

                Intent nextActivityIntent = new Intent(context, ChooseAvatarActivity.class);
                startActivity(nextActivityIntent);
            }
        });

       next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = AvatarActivity.this;
                String nextActivity = "next";
                Toast.makeText(context, nextActivity, Toast.LENGTH_LONG).show();

                /*
                Intent skippedActivityIntent = new Intent(context, SkipActivity.getClass());
                startActivity(skippedActivityIntent);
                переход к следующей странице
                */
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = AvatarActivity.this;
                String nextActivity = "skip";
                Toast.makeText(context, nextActivity, Toast.LENGTH_LONG).show();

                /*
                Intent skippedActivityIntent = new Intent(context, SkipActivity.getClass());
                startActivity(skippedActivityIntent);
                переход к следующей странице без фото
                */
            }
        });
    }
}