package org.shaobig.ralph.generate_alphabet.repository;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VowelAlphabetProvider implements AlphabetProvider {

    @Override
    public List<String> provideAlphabet() {
        return List.of(
                "i", "y", "ɨ", "ʉ", "ɯ", "u", //Close
                "ɪ", "ʏ", "ʊ", //Near-close
                "e", "ø", "ɘ", "ɵ", "ɤ", "o", //Close-mid
                "e̞", "ø̞", "ə", "ɤ̞", "o̞", "o", //Mid
                "ɛ̞", "œ", "ɜ", "ɞ", "ʌ", "ɔ", //Open-mid
                "æ̞", "ɐ", //Near-open
                "a", "ɶ", "ä", "ɑ", "ɒ" //Open
        );
    }

}
