package com.sanjeevani.util;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmergencyClassifier {
    private static final HashMap<Integer, List<String>> urgencyLevels = new HashMap<>();

    static {

        urgencyLevels.put(1, List.of(
                "cardiac arrest",
                "severe bleeding",
                "major trauma",
                "stroke"
        ));


        urgencyLevels.put(2, List.of(
                "chest pain",
                "severe allergic reaction",
                "unconscious",
                "significant trauma"
        ));


        urgencyLevels.put(3, List.of(
                "moderate pain",
                "high fever",
                "possible broken bones"
        ));


        urgencyLevels.put(4, List.of(
                "minor injury",
                "non-emergency",
                "sprains",
                "minor cuts"
        ));


        urgencyLevels.put(5, List.of(
                "routine care",
                "medication refill",
                "follow-up care"
        ));
    }

    public static int classifyUrgency(String emergencyDescription) {
        String lowerCaseDescription = emergencyDescription.toLowerCase();


        for (var entry : urgencyLevels.entrySet()) {
            int level = entry.getKey();
            List<String> keywords = entry.getValue();

            for (String keyword : keywords) {
                if (lowerCaseDescription.contains(keyword)) {
                    return level;
                }
            }
        }

        return 5;
    }
}
