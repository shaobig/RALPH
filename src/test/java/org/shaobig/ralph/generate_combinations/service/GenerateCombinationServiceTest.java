package org.shaobig.ralph.generate_combinations.service;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.ralph.Letter;
import org.shaobig.ralph.LetterType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(value = AccessLevel.PACKAGE)
class GenerateCombinationServiceTest {

    private StreamReduceCombinationSupplier streamReduceCombinationSupplier;;

    private GenerateCombinationService generateCombinationService;

    @BeforeEach
    void init() {
        this.streamReduceCombinationSupplier = Mockito.mock(StreamReduceCombinationSupplier.class);

        this.generateCombinationService = new GenerateCombinationService(streamReduceCombinationSupplier);
    }

    @Test
    void generateCombinationsCheckLetters() {
        List<Letter> sourceLetters = List.of(new Letter("X1", LetterType.VOWEL), new Letter("X2", LetterType.CONSONANT), new Letter("X3", LetterType.VOWEL));

        getGenerateCombinationService().generateCombinations(sourceLetters);

        List<Letter> expected = List.of(new Letter("X1", LetterType.VOWEL), new Letter("X2", LetterType.CONSONANT), new Letter("X3", LetterType.VOWEL));
        Mockito.verify(getStreamReduceCombinationSupplier()).supplyCombinations(expected);
    }

    @Test
    void generateCombinations() {
        List<Letter> sourceLetters = List.of();
        List<String> sourceComposedLetters = List.of("A", "B", "C", "D");
        Mockito.when(getStreamReduceCombinationSupplier().supplyCombinations(Mockito.any())).thenReturn(sourceComposedLetters);

        List<String> actual = getGenerateCombinationService().generateCombinations(sourceLetters);

        List<String> expected = List.of("A", "B", "C", "D");
        assertEquals(expected, actual);
    }

}
