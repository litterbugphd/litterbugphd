package com.e.litterfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Intro extends AppCompatActivity {

    private Button b0;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        logo = findViewById(R.id.logo);
        logo.setImageResource(R.drawable.litter_logo_grey);


        b0 = findViewById(R.id.b0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeginActivty();
            }
        });
    }

    public void BeginActivty() {
        Intent intent = new Intent(Intro.this, BeginActivty.class);
        startActivity(intent);

    }


}

