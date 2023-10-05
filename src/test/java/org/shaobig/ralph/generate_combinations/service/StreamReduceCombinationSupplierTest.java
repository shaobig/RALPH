package org.shaobig.ralph.generate_combinations.service;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.shaobig.ralph.Letter;
import org.shaobig.ralph.LetterType;
import org.shaobig.ralph.generate_combinations.service.composer.LetterCombinationComposer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(value = AccessLevel.PRIVATE)
class StreamReduceCombinationSupplierTest {

    private LetterCombinationComposer letterCombinationComposer;

    private StreamReduceCombinationSupplier streamReduceCombinationSupplier;

    @BeforeEach
    void init() {
        this.letterCombinationComposer = Mockito.mock(LetterCombinationComposer.class);

        this.streamReduceCombinationSupplier = new StreamReduceCombinationSupplier(letterCombinationComposer);
    }

    @Test
    void supplyCombinationsCheckMainLetter() {
        List<Letter> sourceLetters = List.of(new Letter("X1", LetterType.VOWEL), new Letter("X2", LetterType.CONSONANT), new Letter("X3", LetterType.VOWEL));

        getStreamReduceCombinationSupplier().supplyCombinations(sourceLetters);
        ArgumentCaptor<Letter> letterArgumentCaptor = ArgumentCaptor.forClass(Letter.class);
        Mockito.verify(getLetterCombinationComposer(), Mockito.atLeastOnce()).composeCombinations(letterArgumentCaptor.capture(), Mockito.any());
        List<Letter> actual = letterArgumentCaptor.getAllValues();

        List<Letter> expected = List.of(new Letter("X1", LetterType.VOWEL), new Letter("X2", LetterType.CONSONANT), new Letter("X3", LetterType.VOWEL));
        assertEquals(expected, actual);
    }

    @Test
    void supplyCombinationsCheckLetters() {
        List<Letter> sourceLetters = List.of(new Letter("X1", LetterType.VOWEL), new Letter("X2", LetterType.CONSONANT), new Letter("X3", LetterType.VOWEL));

        getStreamReduceCombinationSupplier().supplyCombinations(sourceLetters);

        List<Letter> expected = List.of(new Letter("X1", LetterType.VOWEL), new Letter("X2", LetterType.CONSONANT), new Letter("X3", LetterType.VOWEL));
        Mockito.verify(getLetterCombinationComposer(), Mockito.atLeastOnce()).composeCombinations(Mockito.any(), Mockito.eq(expected));
    }

    @Test
    void supplyCombinationsCheckLetterCombinationComposerInvocationNumber() {
        List<Letter> sourceLetters = List.of(new Letter("X1", LetterType.VOWEL), new Letter("X2", LetterType.CONSONANT), new Letter("X3", LetterType.VOWEL));

        getStreamReduceCombinationSupplier().supplyCombinations(sourceLetters);

        int expected = 3;
        Mockito.verify(getLetterCombinationComposer(), Mockito.times(expected)).composeCombinations(Mockito.any(), Mockito.any());
    }

    @Test
    void supplyCombinations() {
        List<Letter> sourceLetters = List.of(new Letter("", LetterType.VOWEL), new Letter("", LetterType.VOWEL));
        List<String> sourceFirstComposedLetters = List.of("A", "B");
        List<String> sourceSecondComposedLetters = List.of("C", "D");
        Mockito.when(getLetterCombinationComposer().composeCombinations(Mockito.any(), Mockito.any()))
                .thenReturn(sourceFirstComposedLetters)
                .thenReturn(sourceSecondComposedLetters);

        List<String> actual = getStreamReduceCombinationSupplier().supplyCombinations(sourceLetters);

        List<String> expected = List.of("A", "B", "C", "D");
        assertEquals(expected, actual);
    }

}
