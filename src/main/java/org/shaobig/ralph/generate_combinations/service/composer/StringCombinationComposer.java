package org.shaobig.ralph.generate_combinations.service.composer;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StringCombinationComposer implements CombinationComposer<String> {

    @Override
    public List<String> composeCombinations(String mainLetter, List<String> letters) {
        return letters.stream()
                .map(mainLetter::concat)
                .toList();
    }

}
