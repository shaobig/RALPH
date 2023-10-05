package org.shaobig.ralph.generate_combinations.service.composer;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.ralph.Letter;
import org.shaobig.ralph.LetterType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(value = AccessLevel.PRIVATE)
class LetterCombinationComposerTest {

    private StringCombinationComposer stringCombinationComposer;

    private LetterCombinationComposer letterCombinationComposer;

    @BeforeEach
    void init() {
        this.stringCombinationComposer = Mockito.mock(StringCombinationComposer.class);

        this.letterCombinationComposer = new LetterCombinationComposer(stringCombinationComposer);
    }

    @Test
    void composeCombinationsCheckMainLetter() {
        Letter sourceMainLetter = new Letter("X", LetterType.CONSONANT);
        List<Letter> sourceLetters = List.of();

        getLetterCombinationComposer().composeCombinations(sourceMainLetter, sourceLetters);

        String expected = "X";
        Mockito.verify(getStringCombinationComposer()).composeCombinations(Mockito.eq(expected), Mockito.any());
    }

    @Test
    void composeCombinationsCheckLetters() {
        Letter sourceMainLetter = new Letter("", LetterType.CONSONANT);
        List<Letter> sourceLetters = List.of(new Letter("VOWEL_1", LetterType.VOWEL), new Letter("CONSONANT_1", LetterType.CONSONANT), new Letter("VOWEL_2", LetterType.VOWEL));

        getLetterCombinationComposer().composeCombinations(sourceMainLetter, sourceLetters);

        List<String> expected = List.of("VOWEL_1", "VOWEL_2");
        Mockito.verify(getStringCombinationComposer()).composeCombinations(Mockito.anyString(), Mockito.eq(expected));
    }

    @Test
    void composeCombinations() {
        Letter sourceMainLetter = new Letter("", LetterType.CONSONANT);
        List<Letter> sourceLetters = List.of();
        List<String> sourceComposedStringLetters = List.of("XA", "XE");
        Mockito.when(getStringCombinationComposer().composeCombinations(Mockito.anyString(), Mockito.any())).thenReturn(sourceComposedStringLetters);

        List<String> actual = getLetterCombinationComposer().composeCombinations(sourceMainLetter, sourceLetters);

        List<String> expected = List.of("XA", "XE");
        assertEquals(expected, actual);
    }

}
