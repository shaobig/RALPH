package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random.MinMaxRandomGenerator;

@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public abstract class MinMaxRandomAlphabetSizeResolver<T extends Number> implements AlphabetSizeResolver {

    private final MinMaxRandomGenerator<T> minMaxRandomGenerator;

}
