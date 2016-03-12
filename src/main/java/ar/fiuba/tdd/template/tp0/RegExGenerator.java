package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {
    private RegExParser regexParser;

    public RegExGenerator() {
        this.regexParser = new RegExParser();
    }

    public List<String> generate(String regEx, int numberOfResults) {
        List<RegExToken> tokens = this.regexParser.parseString(regEx);
        ArrayList<String> matchedStrings = new ArrayList<String>();
        for ( int i = 0; i < numberOfResults; i++) {
            StringBuilder matchedString = new StringBuilder();
            for ( RegExToken token: tokens) {
                matchedString.append(token.generate());
            }
            matchedStrings.add(matchedString.toString());
        }
        return matchedStrings;
    }
}