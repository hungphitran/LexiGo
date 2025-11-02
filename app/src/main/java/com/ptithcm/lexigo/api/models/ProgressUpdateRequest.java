package com.ptithcm.lexigo.api.models;

import com.google.gson.annotations.SerializedName;

public class ProgressUpdateRequest {
    @SerializedName("vocab_completed")
    private Integer vocabCompleted;

    @SerializedName("grammar_completed")
    private Integer grammarCompleted;

    @SerializedName("listening_completed")
    private Integer listeningCompleted;

    @SerializedName("reading_completed")
    private Integer readingCompleted;

    public ProgressUpdateRequest() {
    }

    public Integer getVocabCompleted() {
        return vocabCompleted;
    }

    public void setVocabCompleted(Integer vocabCompleted) {
        this.vocabCompleted = vocabCompleted;
    }

    public Integer getGrammarCompleted() {
        return grammarCompleted;
    }

    public void setGrammarCompleted(Integer grammarCompleted) {
        this.grammarCompleted = grammarCompleted;
    }

    public Integer getListeningCompleted() {
        return listeningCompleted;
    }

    public void setListeningCompleted(Integer listeningCompleted) {
        this.listeningCompleted = listeningCompleted;
    }

    public Integer getReadingCompleted() {
        return readingCompleted;
    }

    public void setReadingCompleted(Integer readingCompleted) {
        this.readingCompleted = readingCompleted;
    }
}

