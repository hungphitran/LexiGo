package com.ptithcm.lexigo.api.models;

import com.google.gson.annotations.SerializedName;

public class VocabLesson {
    @SerializedName("_id")
    private String id;
    
    @SerializedName("word")
    private String word;
    
    @SerializedName("pronunciation")
    private String pronunciation;
    
    @SerializedName("meaning")
    private String meaning;
    
    @SerializedName("example")
    private String example;
    
    @SerializedName("topic_id")
    private String topicId;
    
    @SerializedName("level")
    private String level;
    
    @SerializedName("image_url")
    private String imageUrl;
    
    @SerializedName("audio_url")
    private String audioUrl;

    // Constructors
    public VocabLesson() {}

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }
}
