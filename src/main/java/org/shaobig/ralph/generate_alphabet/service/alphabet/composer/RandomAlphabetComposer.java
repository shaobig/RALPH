package org.shaobig.ralph.generate_alphabet.service.alphabet.composer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.shaobig.ralph.generate_alphabet.repository.AlphabetProvider;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.MinMaxRandomAlphabetSizeResolver;

@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public abstract class RandomAlphabetComposer<T extends Number> implements AlphabetComposer<String> {

    private final AlphabetProvider alphabetProvider;
    private final MinMaxRandomAlphabetSizeResolver<T> minMaxRandomAlphabetSizeResolver;

}
