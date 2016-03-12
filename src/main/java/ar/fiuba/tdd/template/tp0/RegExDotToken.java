package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by manuelcruz on 11/03/2016.
 */
public class RegExDotToken extends RegExToken {
    private Random random;

    public RegExDotToken(){
        super("");
        this.random = new Random();
    }

    public String generate(){
        int q = this.quantifier.generate();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < q; i++){
            int randomInt = random.nextInt(256);
            //Only Mayus letters
            //int randomInt = random.nextInt(26) + 65;
            //Exclude control characters 0-31 and 92, 127
            /*int randomInt = random.nextInt(222) + 32;
            if(randomInt >= 92){
                randomInt++;
            }
            if(randomInt >= 127){
                randomInt++;
            }*/
            char ch = (char) randomInt;
            stringBuilder.append(ch);
        }
        //System.out.println("----" + stringBuilder.toString() + "----");
        return stringBuilder.toString();
    }
}
