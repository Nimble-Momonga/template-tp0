package ar.fiuba.tdd.template.tp0;

/**
 * Created by manuelcruz on 11/03/2016.
 */
abstract class RegExToken {
    protected String token;
    protected RegExQuantifier quantifier;

    public RegExToken(String token){
        this.token = token;
        this.quantifier = new RegExQuantifier();
    }

    public void setQuantifier(RegExQuantifier quantifier){
        this.quantifier = quantifier;
    }

    abstract String generate();

}
