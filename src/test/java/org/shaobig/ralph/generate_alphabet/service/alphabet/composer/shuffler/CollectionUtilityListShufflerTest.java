package org.shaobig.ralph.generate_alphabet.service.alphabet.composer.shuffler;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(value = AccessLevel.PRIVATE)
class CollectionUtilityListShufflerTest {

    private CollectionUtilityListShuffler<String> collectionUtilityListShuffler;

    @BeforeEach
    void init() {
        this.collectionUtilityListShuffler = new CollectionUtilityListShuffler<>();
    }

    static Stream<Arguments> shuffleListCheckSizeSourceData() {
        return Stream.of(
                Arguments.of(List.of(), 0),
                Arguments.of(List.of("A"), 1),
                Arguments.of(List.of("A", "B"), 2),
                Arguments.of(List.of("A", "B", "C"), 3),
                Arguments.of(List.of("A", "B", "C", "D", "E"), 5)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "shuffleListCheckSizeSourceData")
    void shuffleListCheckSize(List<String> sourceList, int expected) {
        int actual = getCollectionUtilityListShuffler().shuffleList(sourceList).size();

        assertEquals(expected, actual);
    }

}
