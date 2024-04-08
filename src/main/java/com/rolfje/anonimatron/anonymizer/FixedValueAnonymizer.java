package com.rolfje.anonimatron.anonymizer;

import com.rolfje.anonimatron.synonyms.StringSynonym;
import com.rolfje.anonimatron.synonyms.Synonym;

import java.util.HashMap;
import java.util.Map;

public class FixedValueAnonymizer implements Anonymizer {
    private static final String TYPE = "FIXED";

    @Override
    public Synonym anonymize(Object from, int size, boolean shortlived) {
        return anonymize(from, size, shortlived, new HashMap<>());
    }

    @Override
    public Synonym anonymize(Object from, int size, boolean shortlived, Map<String, String> parameters) {
        if (parameters == null || !parameters.containsKey("value")) {
            throw new UnsupportedOperationException("no value");
        }
        return new StringSynonym(getType(),
                (String) from,
                parameters.get("value"),
                shortlived);
    }

    @Override
    public String getType() {
        return TYPE;
    }

}
