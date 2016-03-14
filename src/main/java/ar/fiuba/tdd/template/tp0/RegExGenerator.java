package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {
    private static RegExParser REGEXPARSER = new RegExParser();
    private List<RegExToken> tokens;
    private ArrayList<String> matchedStrings;

    private void parse(String regEx) {
        this.tokens = REGEXPARSER.parseString(regEx);
        this.matchedStrings = new ArrayList<String>();
    }

    private String generateSingleString() {
        StringBuilder matchedString = new StringBuilder();
        for (RegExToken token: this.tokens) {
            matchedString.append(token.generate());
        }
        return matchedString.toString();
    }

    public List<String> generate(String regEx, int numberOfResults) {
        parse(regEx);
        for (int i = 0; i < numberOfResults; i++) {
            this.matchedStrings.add(generateSingleString());
        }
        return this.matchedStrings;
    }
}