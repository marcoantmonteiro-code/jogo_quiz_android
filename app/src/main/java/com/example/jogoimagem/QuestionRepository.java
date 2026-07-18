package com.example.jogoimagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionRepository {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(R.drawable.emo_alegria_01, "Que emoção está presente nesta imagem?", "Alegria", new String[]{"Alegria", "Surpresa", "Interesse", "Tristeza"}, "Boa! A personagem parece muito contente."));
        questions.add(new Question(R.drawable.emo_tristeza_01, "Como se sente esta personagem?", "Tristeza", new String[]{"Tristeza", "Aborrecimento", "Medo", "Serenidade"}, "Muito bem! A postura e o rosto mostram tristeza."));
        questions.add(new Question(R.drawable.emo_medo_01, "Qual é a emoção principal nesta cena?", "Medo", new String[]{"Medo", "Surpresa", "Alegria", "Distração"}, "Certo! A imagem mostra que a personagem está com medo."));
        questions.add(new Question(R.drawable.emo_surpresa_01, "O que está a sentir a personagem?", "Surpresa", new String[]{"Surpresa", "Alegria", "Medo", "Interesse"}, "Boa! A expressão mostra espanto e surpresa."));
        questions.add(new Question(R.drawable.emo_interesse_01, "Como se sente a personagem em relação ao que vê?", "Interesse", new String[]{"Interesse", "Admiração", "Distração", "Aborrecimento"}, "Muito bem! Ela está curiosa e atenta."));
        questions.add(new Question(R.drawable.emo_amor_01, "Que emoção melhor descreve esta cena?", "Amor", new String[]{"Amor", "Confiança", "Alegria", "Medo"}, "Que bonito! A imagem transmite carinho e amor."));
        questions.add(new Question(R.drawable.emo_aborrecimento_01, "Como se sente a personagem com o que está a fazer?", "Aborrecimento", new String[]{"Aborrecimento", "Tristeza", "Serenidade", "Interesse"}, "Certo! Parece sem vontade e pouco envolvida."));
        questions.add(new Question(R.drawable.emo_admiracao_01, "Que emoção melhor descreve a expressão da personagem?", "Admiração", new String[]{"Admiração", "Surpresa", "Alegria", "Medo"}, "Boa! O olhar mostra encanto e admiração."));
        questions.add(new Question(R.drawable.emo_confianca_01, "Como se sente a personagem em relação à outra pessoa?", "Confiança", new String[]{"Confiança", "Amor", "Alegria", "Medo"}, "Muito bem! A cena mostra segurança e confiança."));
        questions.add(new Question(R.drawable.emo_serenidade_01, "Que emoção melhor combina com esta cena calma?", "Serenidade", new String[]{"Serenidade", "Alegria", "Tristeza", "Aborrecimento"}, "Boa! Aqui a emoção principal é calma e serenidade."));
        questions.add(new Question(R.drawable.emo_distracao_01, "Como está a atenção da personagem?", "Distração", new String[]{"Distração", "Interesse", "Aborrecimento", "Surpresa"}, "Certo! Ela está com a atenção desviada."));
        questions.add(new Question(R.drawable.emo_otimismo_01, "Que emoção descreve melhor o modo como a personagem vê o futuro?", "Otimismo", new String[]{"Otimismo", "Alegria", "Medo", "Tristeza"}, "Muito bem! A personagem parece esperançosa e otimista."));

        Collections.shuffle(questions);
        return questions;
    }
}
