package org.shaobig.ralph.generate_alphabet.service.alphabet.composer;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.ralph.generate_alphabet.Letter;
import org.shaobig.ralph.generate_alphabet.LetterType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(value = AccessLevel.PRIVATE)
class IntegerLetterRandomAlphabetComposerTest {

    private IntegerRandomAlphabetComposer randomAlphabetComposer;
    private LetterType letterType;

    private IntegerLetterRandomAlphabetComposer integerLetterRandomAlphabetComposer;

    @BeforeEach
    void init() {
        this.randomAlphabetComposer = Mockito.mock(IntegerRandomAlphabetComposer.class);
        this.letterType = LetterType.VOWEL;

        this.integerLetterRandomAlphabetComposer = new IntegerLetterRandomAlphabetComposer(randomAlphabetComposer, letterType);
    }

    @Test
    void composeAlphabetCheckRandomAlphabetComposerIsInvoked() {
        getIntegerLetterRandomAlphabetComposer().composeAlphabet();

        Mockito.verify(getRandomAlphabetComposer()).composeAlphabet();
    }

    @Test
    void composeAlphabet() {
        List<String> sourceAlphabet = List.of("A", "E", "I");
        Mockito.when(getRandomAlphabetComposer().composeAlphabet()).thenReturn(sourceAlphabet);

        List<Letter> actual = getIntegerLetterRandomAlphabetComposer().composeAlphabet();

        List<Letter> expected = List.of(new Letter("A", LetterType.VOWEL), new Letter("E", LetterType.VOWEL), new Letter("I", LetterType.VOWEL));
        assertEquals(expected, actual);
    }

}
