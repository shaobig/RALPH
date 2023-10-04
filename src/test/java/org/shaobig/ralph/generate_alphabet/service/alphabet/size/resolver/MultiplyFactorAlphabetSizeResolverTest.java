package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(AccessLevel.PRIVATE)
class MultiplyFactorAlphabetSizeResolverTest {

    static Stream<Arguments> resolveSizeInputData() {
        return Stream.of(
                Arguments.of(BigDecimal.ZERO, BigDecimal.ZERO, 0),
                Arguments.of(BigDecimal.ZERO, BigDecimal.ONE, 0),
                Arguments.of(BigDecimal.ONE, BigDecimal.ZERO, 0),
                Arguments.of(BigDecimal.ONE, BigDecimal.ONE, 1),
                Arguments.of(BigDecimal.valueOf(1), BigDecimal.valueOf(1.5), 1),
                Arguments.of(BigDecimal.valueOf(1.5), BigDecimal.valueOf(1), 1),
                Arguments.of(BigDecimal.valueOf(1.3), BigDecimal.valueOf(1.3), 1),
                Arguments.of(BigDecimal.valueOf(1.499), BigDecimal.valueOf(1), 1),
                Arguments.of(BigDecimal.valueOf(1.501), BigDecimal.valueOf(1), 1),
                Arguments.of(BigDecimal.valueOf(1.999), BigDecimal.valueOf(1), 1),
                Arguments.of(BigDecimal.valueOf(2.5), BigDecimal.valueOf(2), 5)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "resolveSizeInputData")
    void resolveSize(BigDecimal sourceFactor, BigDecimal sourceAlphabetSize, int expected) {
        MultiplyFactorAlphabetSizeResolver sourceMultiplyFactorAlphabetSizeResolver = new MultiplyFactorAlphabetSizeResolver(sourceFactor, sourceAlphabetSize);

        int actual = sourceMultiplyFactorAlphabetSizeResolver.resolveSize();

        assertEquals(expected, actual);
    }

}
