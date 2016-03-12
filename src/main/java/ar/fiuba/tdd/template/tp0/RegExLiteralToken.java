package ar.fiuba.tdd.template.tp0;

/**
 * Created by manuelcruz on 11/03/2016.
 */
public class RegExLiteralToken extends RegExToken {
    public RegExLiteralToken(String token) {
        super(token);
    }

    public String generate() {
        int quantity = this.quantifier.generate();
        String generatedString = "";
        for (int i = 0; i < quantity; i++) {
            generatedString += this.token;
        }
        return generatedString;
    }
}
