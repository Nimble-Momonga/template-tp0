package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by manuelcruz on 11/03/2016.
 */
public class RegExSetToken extends RegExToken {
    private Random random;

    public RegExSetToken(String token) {
        super(token);
        this.random = new Random();
    }

    public String generate() {
        int setLength = this.token.length();
        int quantity = this.quantifier.generate();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append(this.token.charAt(random.nextInt(setLength)));
        }
        return stringBuilder.toString();
    }
}
