package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by manuelcruz on 11/03/2016.
 */
public class RegExDotToken extends RegExToken {
    private Random random;

    public RegExDotToken() {
        super("");
        this.random = new Random();
    }

    public String generate() {
        int q = this.quantifier.generate();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int randomInt = random.nextInt(256);
            char ch = (char) randomInt;
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
