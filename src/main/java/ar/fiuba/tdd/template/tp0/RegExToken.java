package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by manuelcruz on 11/03/2016.
 */
public class RegExToken {
    private static Random RANDOM = new Random();
    private Boolean isLiteral;
    private String token;
    private RegExQuantifier quantifier;

    public RegExToken(String token, Boolean literal) {
        this.token = token;
        this.isLiteral = literal;
        this.quantifier = new RegExQuantifier();
    }

    public void setQuantifier(RegExQuantifier quantifier) {
        this.quantifier = quantifier;
    }

    private String generateLiteral() {
        int quantity = this.quantifier.generate();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append(this.token);
        }
        return stringBuilder.toString();
    }

    private String generateDot() {
        int quantity = this.quantifier.generate();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append(RANDOM.nextInt(256));
        }
        return stringBuilder.toString();
    }

    private String generateSet(int tokenLength) {
        int quantity = this.quantifier.generate();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append(this.token.charAt(RANDOM.nextInt(tokenLength)));
        }
        return stringBuilder.toString();
    }

    public String generate() {
        String generated;
        int tokenLength = this.token.length();
        if (tokenLength > 1) {
            generated = generateSet(tokenLength);
        } else {
            if (this.token.equals("*") && !this.isLiteral) {
                generated = generateDot();
            } else {
                generated = generateLiteral();
            }
        }
        return generated;
    }

}
