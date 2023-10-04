package org.shaobig.ralph.generate_alphabet.service.alphabet.composer;

import lombok.AccessLevel;
import lombok.Getter;
import org.shaobig.ralph.generate_alphabet.repository.AlphabetProvider;
import org.shaobig.ralph.generate_alphabet.service.alphabet.composer.shuffler.ListShuffler;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.MinMaxRandomAlphabetSizeResolver;

import java.util.List;

@Getter(value = AccessLevel.PACKAGE)
public class IntegerRandomAlphabetComposer extends RandomAlphabetComposer<Integer> {

    private final ListShuffler<String> stringListShuffler;

    public IntegerRandomAlphabetComposer(AlphabetProvider alphabetProvider, MinMaxRandomAlphabetSizeResolver<Integer> minMaxRandomAlphabetSizeResolver, ListShuffler<String> stringListShuffler) {
        super(alphabetProvider, minMaxRandomAlphabetSizeResolver);
        this.stringListShuffler = stringListShuffler;
    }

    @Override
    public List<String> composeAlphabet() {
        return getStringListShuffler().shuffleList(getAlphabetProvider().provideAlphabet()).stream()
                .limit(getMinMaxRandomAlphabetSizeResolver().resolveSize())
                .toList();
    }

}
