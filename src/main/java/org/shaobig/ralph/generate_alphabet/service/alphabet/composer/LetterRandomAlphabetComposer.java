package org.shaobig.ralph.generate_alphabet.service.alphabet.composer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.shaobig.ralph.Letter;
import org.shaobig.ralph.LetterType;

@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public abstract class LetterRandomAlphabetComposer<T extends Number> implements AlphabetComposer<Letter> {

    private final RandomAlphabetComposer<T> randomAlphabetComposer;
    private final LetterType letterType;

}
