package org.shaobig.ralph.generate_combinations.service.composer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.shaobig.ralph.Letter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public class LetterCombinationComposer implements CombinationComposer<Letter> {

    private final CombinationComposer<String> stringCombinationComposer;

    @Override
    public List<String> composeCombinations(Letter mainLetter, List<Letter> letters) {
        List<String> stringLetters = letters.stream()
                .filter(nextLetter -> !mainLetter.letterType().equals(nextLetter.letterType()))
                .map(Letter::literal)
                .toList();
        return getStringCombinationComposer().composeCombinations(mainLetter.literal(), stringLetters);
    }

}
