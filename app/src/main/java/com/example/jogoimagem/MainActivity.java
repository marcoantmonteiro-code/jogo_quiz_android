package com.example.jogoimagem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView emotionImage;
    private TextView questionText;
    private TextView scoreText;
    private TextView progressText;
    private Button option1, option2, option3, option4;

    private List<Question> questions;
    private int currentIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emotionImage = findViewById(R.id.emotionImage);
        questionText = findViewById(R.id.questionText);
        scoreText = findViewById(R.id.scoreText);
        progressText = findViewById(R.id.progressText);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        questions = QuestionRepository.getQuestions();
        loadQuestion();
    }

    private void loadQuestion() {
        if (currentIndex >= questions.size()) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("total", questions.size());
            startActivity(intent);
            finish();
            return;
        }

        Question question = questions.get(currentIndex);
        emotionImage.setImageResource(question.getImageResId());
        questionText.setText(question.getPrompt());
        scoreText.setText("Pontuação: " + score);
        progressText.setText("Pergunta " + (currentIndex + 1) + " de " + questions.size());

        List<String> shuffledOptions = new ArrayList<>();
        Collections.addAll(shuffledOptions, question.getOptions());
        Collections.shuffle(shuffledOptions);

        option1.setText(shuffledOptions.get(0));
        option2.setText(shuffledOptions.get(1));
        option3.setText(shuffledOptions.get(2));
        option4.setText(shuffledOptions.get(3));

        enableAnswerButtons();

        option1.setOnClickListener(v -> checkAnswer(option1.getText().toString()));
        option2.setOnClickListener(v -> checkAnswer(option2.getText().toString()));
        option3.setOnClickListener(v -> checkAnswer(option3.getText().toString()));
        option4.setOnClickListener(v -> checkAnswer(option4.getText().toString()));
    }

    private void checkAnswer(String selectedAnswer) {
        Question currentQuestion = questions.get(currentIndex);
        boolean isCorrect = selectedAnswer.equals(currentQuestion.getCorrectEmotion());

        disableAnswerButtons();

        if (isCorrect) {
            score++;
            Toast.makeText(this, "Correto! " + currentQuestion.getFeedback(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Boa tentativa! A resposta certa era " + currentQuestion.getCorrectEmotion(), Toast.LENGTH_LONG).show();
        }

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            currentIndex++;
            loadQuestion();
        }, 3600);
    }

    private void disableAnswerButtons() {
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
    }

    private void enableAnswerButtons() {
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);
    }
}