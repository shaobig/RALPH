package org.shaobig.ralph.generate_combinations.service.composer;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(value = AccessLevel.PRIVATE)
class StringCombinationComposerTest {

    private StringCombinationComposer stringCombinationComposer;

    @BeforeEach
    void init() {
        this.stringCombinationComposer = new StringCombinationComposer();
    }

    @Test
    void composeCombinations() {
        String sourceMainLetter = "X";
        List<String> sourceLetters = List.of("A", "B", "C", "D");

        List<String> actual = getStringCombinationComposer().composeCombinations(sourceMainLetter, sourceLetters);

        List<String> expected = List.of("XA", "XB", "XC", "XD");
        assertEquals(expected, actual);
    }

}
