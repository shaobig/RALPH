package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(value = AccessLevel.PRIVATE)
class ProxyMinMaxRandomGeneratorComparatorTest {

    private ProxyMinMaxRandomGeneratorComparator<Integer> proxyMinMaxRandomGeneratorComparator;

    @BeforeEach
    void init() {
        this.proxyMinMaxRandomGeneratorComparator = new ProxyMinMaxRandomGeneratorComparator<>();
    }

    static Stream<Arguments> compareSourceData() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 1, -1),
                Arguments.of(1, 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "compareSourceData")
    void compare(int sourceMin, int sourceMax, int expected) {
        int actual = getProxyMinMaxRandomGeneratorComparator().compare(sourceMin, sourceMax);

        assertEquals(expected, actual);
    }

}
