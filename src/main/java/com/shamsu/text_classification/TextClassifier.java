package com.shamsu.text_classification;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.stereotype.Service;

@Service
class TextClassifier {

    private final ChatClient chatClient;

    TextClassifier(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultOptions(ChatOptionsBuilder.builder()
                        .withTemperature(0.0d)
                        .build())
                .build();
    }

    String checkSentiments(String text) {
        return chatClient
                .prompt()
                .system("""
                        You are an AI assistant specializing in sentiment analysis of customer support case comments. Your task is to classify the sentiment of a given comment into one or more emotion categories. Analyze the text carefully and return the most relevant sentiment labels along with their confidence scores.
                        The possible sentiment categories include:
                        Admiration, Amusement, Anger, Annoyance, Approval, Caring, Confusion, Curiosity, Desire, Disappointment, Disapproval, Disgust, Embarrassment, Excitement, Fear, Gratitude, Grief, Joy, Love, Nervousness, Optimism, Pride, Realization, Relief, Remorse, Sadness, Surprise, and Neutral.
                        If multiple sentiments apply, rank them in order of relevance based on the model's confidence scores percentage. If the sentiment is neutral, explicitly mention it. Provide a concise yet informative response with the Sentiment Analysis: classification and confidence scores percentage along with Explanation separately in a new line.
            """)
                .user(text)
                .call()
                .content();
    }

    String checkCallback(String text) {
        return chatClient
                .prompt()
                .system("""
                        You are an AI assistant specializing in identifying callback requests from customers in customer support case comments. Your task is to analyze the comment and determine whether the customer is explicitly or implicitly requesting a callback from the support team.
                        Provide a concise yet informative response with the Callback Request: {Yes/No} along with Reasoning: {Concise explanation if "Yes"} separately in a new line.
            """)
                .user(text)
                .call()
                .content();
    }

    String checkPotentialEscalation(String text) {
        return chatClient
                .prompt()
                .system("""
                        You are an AI assistant specializing in detecting potential escalations in customer support case comments. Your task is to carefully analyze the comment and determine whether the customer is explicitly stating or implicitly suggesting that they may escalate the case to higher support levels. Explicit escalation indicators may include direct mentions of escalation, complaints about unresolved issues, or threats to involve supervisors or higher management. Implicit signs may include repeated frustration, dissatisfaction with prior responses, urgency, or references to seeking alternative solutions.
                        Provide a concise yet informative response with the Potential Escalation: {Yes/No} along with Explanation: {Concise explanation if "Yes"} separately in a new line.
            """)
                .user(text)
                .call()
                .content();
    }

}