package com.shamsu.text_classification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private Utils() {
    }

    public static SentimentAnalysisPojo parseSentimentAnalysis(String input) {
        SentimentAnalysisPojo pojo = new SentimentAnalysisPojo();

        Pattern sentimentPattern = Pattern.compile( "Sentiment Analysis:(.+?)" + "Explanation:", Pattern.DOTALL);
        Pattern explanationPattern = Pattern.compile("Explanation: (.+)", Pattern.DOTALL);

        Matcher sentimentMatcher = sentimentPattern.matcher(input);
        Matcher explanationMatcher = explanationPattern.matcher(input);

        if (sentimentMatcher.find()) {
            pojo.setSentiment(sentimentMatcher.group(1).trim());
        }

        if (explanationMatcher.find()) {
            pojo.setExplanation(explanationMatcher.group(1).trim());
        }

        return pojo;
    }

    public static CallbackPojo parseCallBack(String input) {
        CallbackPojo pojo = new CallbackPojo();

        Pattern callbackPattern = Pattern.compile("Callback Request: (.+)");
        Pattern reasoningPattern = Pattern.compile("Reasoning: (.+)", Pattern.DOTALL);

        Matcher callbackMatcher = callbackPattern.matcher(input);
        Matcher reasoningMatcher = reasoningPattern.matcher(input);

        if (callbackMatcher.find()) {
            pojo.setCallback(callbackMatcher.group(1).trim());
        }

        if (reasoningMatcher.find()) {
            pojo.setExplanation(reasoningMatcher.group(1).trim());
        }

        return pojo;
    }

    public static PotentialEscalationPojo parsePotentialEscalation(String input){
        PotentialEscalationPojo pojo = new PotentialEscalationPojo();

        Pattern potentialEscalationPattern = Pattern.compile("Potential Escalation: (.+)");
        Pattern explanationPattern = Pattern.compile("Explanation: (.+)", Pattern.DOTALL);

        Matcher potentialEscalationMatcher = potentialEscalationPattern.matcher(input);
        Matcher explanationMatcher = explanationPattern.matcher(input);

        if (potentialEscalationMatcher.find()) {
            pojo.setPotentialEscalation(potentialEscalationMatcher.group(1).trim());
        }

        if (explanationMatcher.find()) {
            pojo.setExplanation(explanationMatcher.group(1).trim());
        }

        return pojo;
    }
}
