package org.shaobig.ralph.generate_alphabet.service.alphabet.composer;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.shaobig.ralph.generate_alphabet.repository.AlphabetProvider;
import org.shaobig.ralph.generate_alphabet.service.alphabet.composer.shuffler.ListShuffler;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.FactorIntegerMinMaxRandomAlphabetSizeResolver;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(value = AccessLevel.PRIVATE)
class IntegerRandomAlphabetComposerTest {

    private AlphabetProvider alphabetProvider;
    private FactorIntegerMinMaxRandomAlphabetSizeResolver minMaxRandomAlphabetSizeResolver;
    private ListShuffler<String> stringListShuffler;

    private IntegerRandomAlphabetComposer integerRandomAlphabetComposer;

    @BeforeEach
    void init() {
        this.alphabetProvider = Mockito.mock(AlphabetProvider.class);
        this.minMaxRandomAlphabetSizeResolver = Mockito.mock(FactorIntegerMinMaxRandomAlphabetSizeResolver.class);
        this.stringListShuffler = Mockito.mock(ListShuffler.class);

        this.integerRandomAlphabetComposer = new IntegerRandomAlphabetComposer(alphabetProvider, minMaxRandomAlphabetSizeResolver, stringListShuffler);
    }

    @Test
    void composeAlphabetCheckAlphabetProviderIsInvoked() {
        getIntegerRandomAlphabetComposer().composeAlphabet();

        Mockito.verify(getAlphabetProvider()).provideAlphabet();
    }

    @Test
    void composeAlphabetCheckMinMaxRandomAlphabetSizeResolverIsInvoked() {
        List<String> sourceAlphabetLetters = List.of();
        Mockito.when(getStringListShuffler().shuffleList(Mockito.anyList())).thenReturn(sourceAlphabetLetters);

        getIntegerRandomAlphabetComposer().composeAlphabet();

        Mockito.verify(getMinMaxRandomAlphabetSizeResolver()).resolveSize();
    }

    @Test
    void composeAlphabetCheckListShuffler() {
        List<String> sourceAlphabetLetters = List.of("A", "B", "C");
        Mockito.when(getAlphabetProvider().provideAlphabet()).thenReturn(sourceAlphabetLetters);

        getIntegerRandomAlphabetComposer().composeAlphabet();

        List<String> expectedAlphabetLetters = List.of("A", "B", "C");
        Mockito.verify(getStringListShuffler()).shuffleList(expectedAlphabetLetters);
    }

    static Stream<Arguments> composeAlphabetSourceData() {
        return Stream.of(
                Arguments.of(3, List.of("A", "B", "C")),
                Arguments.of(2, List.of("A", "B"))
        );
    }

    @ParameterizedTest
    @MethodSource(value = "composeAlphabetSourceData")
    void composeAlphabet(int sourceAlphabetSize, List<String> expected) {
        int sourceFirstRandomHashCode = 0;
        int sourceSecondRandomHashCode = 1;
        int sourceThirdRandomHashCode = 2;
        List<String> sourceAlphabetLetters = List.of("A", "B", "C");
        Mockito.when(getMinMaxRandomAlphabetSizeResolver().resolveSize())
                .thenReturn(sourceAlphabetSize)
                .thenReturn(sourceFirstRandomHashCode)
                .thenReturn(sourceSecondRandomHashCode)
                .thenReturn(sourceThirdRandomHashCode);
        Mockito.when(getStringListShuffler().shuffleList(Mockito.anyList())).thenReturn(sourceAlphabetLetters);

        List<String> actual = getIntegerRandomAlphabetComposer().composeAlphabet();

        assertEquals(expected, actual);
    }

}
