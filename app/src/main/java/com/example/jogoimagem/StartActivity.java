package com.example.jogoimagem;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        TextView homeTitle = findViewById(R.id.homeTitle);
        ImageView homeLogo = findViewById(R.id.homeLogo);
        Button btnStart = findViewById(R.id.btnStart);

        // Carregar animações
        Animation pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
        Animation floating = AnimationUtils.loadAnimation(this, R.anim.floating_anim);

        // Aplicar animações
        btnStart.startAnimation(pulse);
        homeLogo.startAnimation(floating);
        homeTitle.startAnimation(floating);

        btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}