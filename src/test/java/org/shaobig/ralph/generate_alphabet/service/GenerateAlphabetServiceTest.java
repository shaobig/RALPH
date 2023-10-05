package org.shaobig.ralph.generate_alphabet.service;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.ralph.Letter;
import org.shaobig.ralph.LetterType;
import org.shaobig.ralph.generate_alphabet.service.alphabet.composer.IntegerLetterRandomAlphabetComposer;
import org.shaobig.ralph.generate_alphabet.service.alphabet.composer.LetterRandomAlphabetComposer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(value = AccessLevel.PRIVATE)
class GenerateAlphabetServiceTest {

    private IntegerLetterRandomAlphabetComposer vowelIntegerLetterRandomAlphabetComposer;
    private IntegerLetterRandomAlphabetComposer consonantIntegerLetterRandomAlphabetComposer;
    private List<LetterRandomAlphabetComposer<Integer>> letterRandomAlphabetComposers;

    private GenerateAlphabetService generateAlphabetService;

    @BeforeEach
    void init() {
        this.vowelIntegerLetterRandomAlphabetComposer = Mockito.mock(IntegerLetterRandomAlphabetComposer.class);
        this.consonantIntegerLetterRandomAlphabetComposer = Mockito.mock(IntegerLetterRandomAlphabetComposer.class);
        this.letterRandomAlphabetComposers = List.of(vowelIntegerLetterRandomAlphabetComposer, consonantIntegerLetterRandomAlphabetComposer);

        this.generateAlphabetService = new GenerateAlphabetService(letterRandomAlphabetComposers);
    }

    @Test
    void generateAlphabet() {
        List<Letter> sourceVowelLetters = List.of(new Letter("V1", LetterType.VOWEL), new Letter("V2", LetterType.VOWEL), new Letter("V3", LetterType.VOWEL));
        List<Letter> sourceConsonantLetters = List.of(new Letter("C1", LetterType.CONSONANT), new Letter("C2", LetterType.CONSONANT), new Letter("C3", LetterType.CONSONANT));
        Mockito.when(getVowelIntegerLetterRandomAlphabetComposer().composeAlphabet()).thenReturn(sourceVowelLetters);
        Mockito.when(getConsonantIntegerLetterRandomAlphabetComposer().composeAlphabet()).thenReturn(sourceConsonantLetters);

        List<Letter> actual = getGenerateAlphabetService().generateAlphabet();

        List<Letter> expected = List.of(new Letter("V1", LetterType.VOWEL), new Letter("V2", LetterType.VOWEL), new Letter("V3", LetterType.VOWEL), new Letter("C1", LetterType.CONSONANT), new Letter("C2", LetterType.CONSONANT), new Letter("C3", LetterType.CONSONANT));
        assertEquals(expected, actual);
    }

}
