package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random;

public interface MinMaxRandomGenerator<T extends Number> {

    T generateRandomNumber(T min, T max);

}
