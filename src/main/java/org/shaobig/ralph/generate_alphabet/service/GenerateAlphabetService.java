package org.shaobig.ralph.generate_alphabet.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.shaobig.ralph.Letter;
import org.shaobig.ralph.generate_alphabet.service.alphabet.composer.AlphabetComposer;
import org.shaobig.ralph.generate_alphabet.service.alphabet.composer.LetterRandomAlphabetComposer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public class GenerateAlphabetService {

    private final List<LetterRandomAlphabetComposer<Integer>> letterRandomAlphabetComposers;

    public List<Letter> generateAlphabet() {
        return getLetterRandomAlphabetComposers().stream()
                .map(AlphabetComposer::composeAlphabet)
                .flatMap(List::stream)
                .toList();
    }

}
