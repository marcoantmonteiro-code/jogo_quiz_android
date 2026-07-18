package com.example.jogoimagem;

public class Question {
    private final int imageResId;
    private final String prompt;
    private final String correctEmotion;
    private final String[] options;
    private final String feedback;

    public Question(int imageResId, String prompt, String correctEmotion, String[] options, String feedback) {
        this.imageResId = imageResId;
        this.prompt = prompt;
        this.correctEmotion = correctEmotion;
        this.options = options;
        this.feedback = feedback;
    }

    public int getImageResId() { return imageResId; }
    public String getPrompt() { return prompt; }
    public String getCorrectEmotion() { return correctEmotion; }
    public String[] getOptions() { return options; }
    public String getFeedback() { return feedback; }
}
