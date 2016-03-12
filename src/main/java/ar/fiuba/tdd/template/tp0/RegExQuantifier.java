package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by manuelcruz on 11/03/2016.
 */
public class RegExQuantifier {
    private String quantifier;
    private int maxLength = 50;
    private Random random = new Random();

    public RegExQuantifier(){
        this.quantifier = "";
    }

    public RegExQuantifier(String quantifier) {
        this.quantifier = quantifier;
    }

    public int generate(){
        int generated;
        switch(this.quantifier){
            case "+":
                generated = this.random.nextInt(this.maxLength);
                generated++;
                break;
            case "*":
                generated = this.random.nextInt(this.maxLength + 1);
                break;
            case "?":
                generated = this.random.nextInt(2);
                break;
            default:
                generated = 1;
                break;
        }
        return generated;
    }
}
