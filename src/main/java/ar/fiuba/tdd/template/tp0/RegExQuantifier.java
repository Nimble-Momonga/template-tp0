package ar.fiuba.tdd.template.tp0;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by manuelcruz on 11/03/2016.
 */
interface Generator {
    int run();
}

public class RegExQuantifier {
    private static int MAXLENGTH = 50;
    private static Random RANDOM = new Random();
    private static final Map<String, Generator> GENERATORS;
    static {
        GENERATORS = new HashMap<>();
        GENERATORS.put("+", () -> RANDOM.nextInt(MAXLENGTH) + 1);
        GENERATORS.put("*", () -> RANDOM.nextInt(MAXLENGTH + 1));
        GENERATORS.put("?", () -> RANDOM.nextInt(2));
    }
    private String quantifier;

    public RegExQuantifier() {
        this.quantifier = "";
    }

    public RegExQuantifier(String quantifier) {
        this.quantifier = quantifier;
    }

    public int generate() {
        return GENERATORS.containsKey(this.quantifier) ? GENERATORS.get(this.quantifier).run() : 1;
    }
}
