package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Getter(value = AccessLevel.PRIVATE)
class IntegerMinMaxRandomGeneratorTest {

    private IntegerMinMaxRandomGenerator integerMinMaxRandomGenerator;

    @BeforeEach
    void init() {
        this.integerMinMaxRandomGenerator = new IntegerMinMaxRandomGenerator();
    }

    static Stream<Arguments> generateRandomNumberSourceData() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 3),
                Arguments.of(1, 10),
                Arguments.of(5, 10)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "generateRandomNumberSourceData")
    void generateRandomNumber(int sourceMin, int sourceMax) {
        int actual = getIntegerMinMaxRandomGenerator().generateRandomNumber(sourceMin, sourceMax);

        assertTrue(sourceMin <= actual && actual <= sourceMax);
    }

}
