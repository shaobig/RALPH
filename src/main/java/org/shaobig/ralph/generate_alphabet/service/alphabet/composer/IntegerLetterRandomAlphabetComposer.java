package org.shaobig.ralph.generate_alphabet.service.alphabet.composer;

import org.shaobig.ralph.Letter;
import org.shaobig.ralph.LetterType;

import java.util.List;

public class IntegerLetterRandomAlphabetComposer extends LetterRandomAlphabetComposer<Integer> {

    public IntegerLetterRandomAlphabetComposer(RandomAlphabetComposer<Integer> randomAlphabetComposer, LetterType letterType) {
        super(randomAlphabetComposer, letterType);
    }

    @Override
    public List<Letter> composeAlphabet() {
        return getRandomAlphabetComposer().composeAlphabet().stream()
                .map(literal -> new Letter(literal, getLetterType()))
                .toList();
    }

}
