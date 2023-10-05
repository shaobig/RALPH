package org.shaobig.ralph.generate_combinations.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.shaobig.ralph.Letter;
import org.shaobig.ralph.generate_combinations.service.composer.CombinationComposer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public class AnalyticCombinationSupplier implements CombinationSupplier {

    private final CombinationComposer<Letter> combinationComposer;

    @Override
    public List<String> supplyCombinations(List<Letter> letters) {
        return letters.stream().reduce(new ArrayList<>(), (combinations, letter) -> {
            combinations.addAll(getCombinationComposer().composeCombinations(letter, letters));
            return combinations;
        }, (combinationsLeft, combinationsRight) -> combinationsLeft);
    }

}
