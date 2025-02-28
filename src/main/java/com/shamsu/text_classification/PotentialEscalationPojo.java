package com.shamsu.text_classification;

import java.util.Objects;

public class PotentialEscalationPojo {

    private String potentialEscalation;
    private String explanation;

    public PotentialEscalationPojo() {
    }

    public PotentialEscalationPojo(String potentialEscalation, String explanation) {
        this.potentialEscalation = potentialEscalation;
        this.explanation = explanation;
    }

    public String getPotentialEscalation() {
        return potentialEscalation;
    }

    public void setPotentialEscalation(String potentialEscalation) {
        this.potentialEscalation = potentialEscalation;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PotentialEscalationPojo that = (PotentialEscalationPojo) o;
        return Objects.equals(getPotentialEscalation(), that.getPotentialEscalation()) && Objects.equals(getExplanation(), that.getExplanation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPotentialEscalation(), getExplanation());
    }

    @Override
    public String toString() {
        return "PotentialEscalation{" +
                "potentialEscalation='" + potentialEscalation + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
