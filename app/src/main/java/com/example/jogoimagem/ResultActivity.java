package com.example.jogoimagem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTitle = findViewById(R.id.resultTitle);
        TextView resultText = findViewById(R.id.resultText);
        TextView starsText = findViewById(R.id.starsText);
        Button restartButton = findViewById(R.id.restartButton);
        Button menuButton = findViewById(R.id.menuButton);

        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 0);

        resultText.setText("Acertaste " + score + " de " + total + " emoções!");

        if (score >= 10) {
            resultTitle.setText("Fantástico!");
            starsText.setText("⭐ ⭐ ⭐\nÉs uma estrela das emoções!");
        } else if (score >= 6) {
            resultTitle.setText("Muito bem!");
            starsText.setText("⭐ ⭐\nJá reconheces muitas emoções!");
        } else {
            resultTitle.setText("Boa tentativa!");
            starsText.setText("⭐\nVamos brincar outra vez!");
        }

        restartButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        menuButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, StartActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
