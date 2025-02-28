package com.shamsu.text_classification;

import java.util.Objects;

public class CallbackPojo {

    private String callback;
    private String explanation;

    public CallbackPojo() {
    }

    public CallbackPojo(String callback, String explanation) {
        this.callback = callback;
        this.explanation = explanation;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CallbackPojo that)) return false;
        return Objects.equals(getCallback(), that.getCallback()) && Objects.equals(getExplanation(), that.getExplanation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCallback(), getExplanation());
    }

    @Override
    public String toString() {
        return "CallbackPojo{" +
                "callback='" + callback + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
