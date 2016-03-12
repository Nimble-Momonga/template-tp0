package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manuelcruz on 11/03/2016.
 */
public class RegExParser {
    private String stringToParse;
    private ArrayList<RegExToken> parsedString;
    private Boolean escaped;

    private void init(String string){
        this.stringToParse = string;
        this.parsedString = new ArrayList<RegExToken>();
        this.escaped = false;
    }

    private int parseSet(int i){
        StringBuilder str = new StringBuilder();
        i++;
        while(this.stringToParse.charAt(i) != ']') {
            str.append(this.stringToParse.charAt(i));
            i++;
        }
        this.parsedString.add(new RegExSetToken(str.toString()));
        return i;
    }

    private void parseLiteral(String character){
        this.parsedString.add(new RegExLiteralToken(character));
    }

    private void parseChar(String character){
        if(character.equals("+") || character.equals("*") || character.equals("?")){
            RegExToken lastToken = this.parsedString.get(this.parsedString.size() - 1);
            lastToken.setQuantifier(new RegExQuantifier(character));
        } else {
            if(character.equals(".")){
                this.parsedString.add(new RegExDotToken());
            } else{
                this.parsedString.add(new RegExLiteralToken(character));
            }
        }
    }

    public List<RegExToken> parseString(String stringToParse){
        init(stringToParse);
        for(int i = 0; i < this.stringToParse.length(); i++){
            String character = Character.toString(this.stringToParse.charAt(i));
            if(this.escaped){
                parseLiteral(character);
                this.escaped = false;
            } else {
                if(character.equals("\\")) {
                    this.escaped = true;
                } else {
                    if(character.equals("[")){
                        i = parseSet(i);
                    } else{
                        parseChar(character);
                    }
                }
            }
        }
        return this.parsedString;
    }
}
