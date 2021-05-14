package com.example.ossapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class ChooseAvatarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_avatar);

        Button back = (Button) findViewById(R.id.back);
        ImageButton bruce = (ImageButton) findViewById(R.id.bruce);
        ImageButton tyson = (ImageButton) findViewById(R.id.tyson);
        ImageButton habib = (ImageButton) findViewById(R.id.habib);
        ImageButton mcgregor = (ImageButton) findViewById(R.id.mcgregor);
        ImageButton chan = (ImageButton) findViewById(R.id.chan);
        ImageButton vandamme = (ImageButton) findViewById(R.id.vandamme);

        /*
        метод перехода в AvavtarActivity без аватара
         */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = ChooseAvatarActivity.this;
                Intent nextActivityIntent = new Intent(context, AvatarActivity.class);
                startActivity(nextActivityIntent);
            }
        });
        /*
        метод перехода в AvavtarActivity с аватаром bruce
        (картинки позже поменяем)
        */
        bruce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosingAvatar(bruce);
            }
        });

        tyson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosingAvatar(tyson);
            }
        });

        habib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosingAvatar(habib);
            }
        });

        mcgregor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosingAvatar(mcgregor);
            }
        });

        chan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosingAvatar(chan);
            }
        });

        vandamme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosingAvatar(vandamme);
            }
        });
    }

    /*
    метод, который отправляет изображение из
    ChoooseAvatarActivity в AvavtarActivity
    требует дальнейшей доработки
     */
    private void choosingAvatar(ImageButton image) {
        Context context = ChooseAvatarActivity.this;

        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 50, out);
        byte[] images = out.toByteArray();

        Intent nextActivityIntent = new Intent(context, AvatarActivity.class);
        nextActivityIntent.putExtra("picture", images);

        startActivity(nextActivityIntent);
    }
}
