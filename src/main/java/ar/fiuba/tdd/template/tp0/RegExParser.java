package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manuelcruz on 11/03/2016.
 */
public class RegExParser {
    private String stringToParse;
    private ArrayList<RegExToken> parsedString;

    private Boolean isQuantifier(String character) {
        return (character.equals("+") || character.equals("*") || character.equals("?"));
    }

    private void init(String string) {
        this.stringToParse = string;
        this.parsedString = new ArrayList<RegExToken>();
    }

    private int parseSet(int position) {
        StringBuilder str = new StringBuilder();
        position++;
        while (this.stringToParse.charAt(position) != ']') {
            str.append(this.stringToParse.charAt(position));
            position++;
        }
        parseLiteral(str.toString());
        return position;
    }

    private void parseLiteral(String token) {
        this.parsedString.add(new RegExToken(token, true));
    }

    private void parseChar(String token) {
        if (isQuantifier(token)) {
            RegExToken lastToken = this.parsedString.get(this.parsedString.size() - 1);
            lastToken.setQuantifier(new RegExQuantifier(token));
        } else {
            this.parsedString.add(new RegExToken(token, false));
        }
    }

    public List<RegExToken> parseString(String stringToParse) {
        init(stringToParse);
        Boolean escaped = false;
        for (int i = 0; i < this.stringToParse.length(); i++) {
            String character = Character.toString(this.stringToParse.charAt(i));
            if (escaped) {
                parseLiteral(character);
                escaped = false;
            } else {
                if (character.equals("\\")) {
                    escaped = true;
                } else {
                    if (character.equals("[")) {
                        i = parseSet(i);
                    } else {
                        parseChar(character);
                    }
                }
            }
        }
        return this.parsedString;
    }
}
