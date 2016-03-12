package ar.fiuba.tdd.template.tp0;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class RegExGeneratorTest {

    private boolean validate(String regEx, int numberOfResults) {
        RegExGenerator generator = new RegExGenerator();
        List<String> results = generator.generate(regEx, numberOfResults);
        Pattern pattern = Pattern.compile("^" + regEx + "$", Pattern.DOTALL);
        return results
                .stream()
                .reduce(true,
                    (acc, item) -> {
                        Matcher matcher = pattern.matcher(item);
                        return acc && matcher.find();
                    },
                    (item1, item2) -> item1 && item2);
    }

    @Test
    public void testAnyCharacter() {
        assertTrue(validate(".", 50));
    }

    @Test
    public void testMultipleCharacters() {
        assertTrue(validate("...", 50));
    }

    @Test
    public void testLiteral() {
        assertTrue(validate("\\@", 50));
    }

    @Test
    public void testLiteralDotCharacter() {
        assertTrue(validate("\\@..", 50));
    }

    @Test
    public void testZeroOrOneCharacter() {
        assertTrue(validate("\\@.h?", 50));
    }

    @Test
    public void testCharacterSet() {
        assertTrue(validate("[abc]", 50));
    }

    @Test
    public void testCharacterSetWithQuantifiers() {
        assertTrue(validate("[abc]+", 50));
    }

    @Test
    public void testDotCharacterWithPlusQuantifier() {
        assertTrue(validate(".+", 50));
    }

    @Test
    public void testDotCharacterWithAsteriskQuantifier() {
        assertTrue(validate(".*", 50));
    }

    @Test
    public void testAllSpecialCharacters() {
        assertTrue(validate(".*a?b+[cde]\\.", 50));
    }

    @Test
    public void testCharacterSetWithAsteriskQuantifier() {
        assertTrue(validate("[abcde]*", 50));
    }

}
