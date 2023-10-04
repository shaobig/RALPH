package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public class ProxyMinMaxRandomGenerator<T extends Number> implements MinMaxRandomGenerator<T> {

    private final ProxyMinMaxRandomGeneratorComparator<T> proxyMinMaxRandomGeneratorComparator;
    private final MinMaxRandomGenerator<T> minMaxRandomGenerator;

    @Override
    public T generateRandomNumber(T min, T max) {
        if (getProxyMinMaxRandomGeneratorComparator().compare(min, max) > 0) {
            throw new IllegalArgumentException("The max value should be bigger than the min value!");
        }
        return getMinMaxRandomGenerator().generateRandomNumber(min, max);
    }

}
