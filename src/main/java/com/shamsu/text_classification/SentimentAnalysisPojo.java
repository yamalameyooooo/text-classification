package com.shamsu.text_classification;

import java.util.Objects;

public class SentimentAnalysisPojo {

    private String sentiment;
    private String explanation;

    public SentimentAnalysisPojo(String sentiment, String explanation) {
        this.sentiment = sentiment;
        this.explanation = explanation;
    }

    public SentimentAnalysisPojo() {
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SentimentAnalysisPojo that)) return false;
        return Objects.equals(getSentiment(), that.getSentiment()) && Objects.equals(getExplanation(), that.getExplanation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSentiment(), getExplanation());
    }

    @Override
    public String toString() {
        return "SentimentAnalysisPojo{" +
                "sentiment='" + sentiment + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }


}
