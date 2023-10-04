package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Getter(value = AccessLevel.PRIVATE)
class ProxyMinMaxRandomGeneratorTest {

    private ProxyMinMaxRandomGeneratorComparator<Integer> proxyMinMaxRandomGeneratorComparator;
    private MinMaxRandomGenerator<Integer> minMaxRandomGenerator;

    private ProxyMinMaxRandomGenerator<Integer> proxyMinMaxRandomGenerator;

    private static class StubProxyMinMaxRandomGeneratorComparator extends ProxyMinMaxRandomGeneratorComparator<Integer> {}

    @BeforeEach
    void init() {
        this.proxyMinMaxRandomGeneratorComparator = Mockito.mock(StubProxyMinMaxRandomGeneratorComparator.class);
        this.minMaxRandomGenerator = Mockito.mock(IntegerMinMaxRandomGenerator.class);

        this.proxyMinMaxRandomGenerator = new ProxyMinMaxRandomGenerator<>(proxyMinMaxRandomGeneratorComparator, minMaxRandomGenerator);
    }

    @Test
    void generateRandomNumberCompareMin() {
        int sourceMin = 0;
        int sourceMax = 1;

        getProxyMinMaxRandomGenerator().generateRandomNumber(sourceMin, sourceMax);

        int expectedMin = 0;
        Mockito.verify(getProxyMinMaxRandomGeneratorComparator()).compare(Mockito.eq(expectedMin), Mockito.anyInt());
    }

    @Test
    void generateRandomNumberCompareMax() {
        int sourceMin = 0;
        int sourceMax = 1;

        getProxyMinMaxRandomGenerator().generateRandomNumber(sourceMin, sourceMax);

        int expectedMax = 1;
        Mockito.verify(getProxyMinMaxRandomGeneratorComparator()).compare(Mockito.anyInt(), Mockito.eq(expectedMax));
    }

    @Test
    void generateRandomNumberMinIsBiggerThanMax() {
        int sourceCompareValue = 1;
        int sourceMin = 1;
        int sourceMax = 0;
        Mockito.when(getProxyMinMaxRandomGeneratorComparator().compare(Mockito.anyInt(), Mockito.anyInt())).thenReturn(sourceCompareValue);

        assertThrows(IllegalArgumentException.class, () -> getProxyMinMaxRandomGenerator().generateRandomNumber(sourceMin, sourceMax));
    }

    @Test
    void generateRandomNumber() {
        int sourceMin = 0;
        int sourceMax = 1;
        int sourceRandomNumber = 1;
        Mockito.when(getMinMaxRandomGenerator().generateRandomNumber(Mockito.anyInt(), Mockito.anyInt())).thenReturn(sourceRandomNumber);

        int actual = getProxyMinMaxRandomGenerator().generateRandomNumber(sourceMin, sourceMax);

        int expected = 1;
        assertEquals(expected, actual);
    }

}
