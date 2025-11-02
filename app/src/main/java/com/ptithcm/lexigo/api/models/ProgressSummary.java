package com.ptithcm.lexigo.api.models;

import com.google.gson.annotations.SerializedName;

public class ProgressSummary {
    @SerializedName("total_vocab")
    private int totalVocab;

    @SerializedName("total_grammar")
    private int totalGrammar;

    @SerializedName("total_listening")
    private int totalListening;

    @SerializedName("total_reading")
    private int totalReading;

    @SerializedName("total_completed")
    private int totalCompleted;

    @SerializedName("last_updated")
    private String lastUpdated;

    public ProgressSummary() {
    }

    public int getTotalVocab() {
        return totalVocab;
    }

    public void setTotalVocab(int totalVocab) {
        this.totalVocab = totalVocab;
    }

    public int getTotalGrammar() {
        return totalGrammar;
    }

    public void setTotalGrammar(int totalGrammar) {
        this.totalGrammar = totalGrammar;
    }

    public int getTotalListening() {
        return totalListening;
    }

    public void setTotalListening(int totalListening) {
        this.totalListening = totalListening;
    }

    public int getTotalReading() {
        return totalReading;
    }

    public void setTotalReading(int totalReading) {
        this.totalReading = totalReading;
    }

    public int getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(int totalCompleted) {
        this.totalCompleted = totalCompleted;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

