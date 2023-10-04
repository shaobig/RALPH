package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random.IntegerMinMaxRandomGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter(value = AccessLevel.PRIVATE)
class FactorIntegerMinMaxRandomAlphabetSizeResolverTest {

    private IntegerMinMaxRandomGenerator integerMinMaxRandomGenerator;
    private FactorAlphabetSizeResolver minFactorAlphabetSizeResolver;
    private FactorAlphabetSizeResolver maxFactorAlphabetSizeResolver;

    private FactorIntegerMinMaxRandomAlphabetSizeResolver factorRandomAlphabetSizeResolver;

    @BeforeEach
    void init() {
        this.integerMinMaxRandomGenerator = Mockito.mock(IntegerMinMaxRandomGenerator.class);
        this.minFactorAlphabetSizeResolver = Mockito.mock(FactorAlphabetSizeResolver.class);
        this.maxFactorAlphabetSizeResolver = Mockito.mock(FactorAlphabetSizeResolver.class);

        this.factorRandomAlphabetSizeResolver = new FactorIntegerMinMaxRandomAlphabetSizeResolver(integerMinMaxRandomGenerator, minFactorAlphabetSizeResolver, maxFactorAlphabetSizeResolver);
    }

    @Test
    void resolveSizeMinFactorAlphabetSizeResolver() {
        getFactorRandomAlphabetSizeResolver().resolveSize();

        Mockito.verify(getMinFactorAlphabetSizeResolver()).resolveSize();
    }

    @Test
    void resolveSizeMaxFactorAlphabetSizeResolver() {
        getFactorRandomAlphabetSizeResolver().resolveSize();

        Mockito.verify(getMaxFactorAlphabetSizeResolver()).resolveSize();
    }

    @Test
    void resolveSize() {
        int sourceSize = 1;
        Mockito.when(getIntegerMinMaxRandomGenerator().generateRandomNumber(Mockito.anyInt(), Mockito.anyInt())).thenReturn(sourceSize);

        int actual = getFactorRandomAlphabetSizeResolver().resolveSize();

        int expected = 1;
        assertEquals(expected, actual);
    }

}
