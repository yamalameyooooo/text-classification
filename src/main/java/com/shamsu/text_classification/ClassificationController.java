package com.shamsu.text_classification;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
class ClassificationController {

    private final TextClassifier textClassifier;

    ClassificationController(TextClassifier textClassifier) {
        this.textClassifier = textClassifier;
    }

    @PostMapping("/sentiments")
    SentimentAnalysisPojo checkSentiments(@RequestBody String text) {
        String aiResponse = textClassifier.checkSentiments(text).strip();
        return Utils.parseSentimentAnalysis(aiResponse);
    }

    @PostMapping("/callback")
    CallbackPojo checkCallback(@RequestBody String text) {
        String aiResponse = textClassifier.checkCallback(text).strip();
        return Utils.parseCallBack(aiResponse);
    }

    @PostMapping("/potential-escalation")
    PotentialEscalationPojo checkPotentialEscalation(@RequestBody String text) {
        String aiResponse = textClassifier.checkPotentialEscalation(text).strip();
        return Utils.parsePotentialEscalation(aiResponse);
    }

}
