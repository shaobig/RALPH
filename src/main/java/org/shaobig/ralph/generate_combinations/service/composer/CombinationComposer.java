package org.shaobig.ralph.generate_combinations.service.composer;

import java.util.List;

public interface CombinationComposer<T> {

    List<String> composeCombinations(T mainLetter, List<T> letters);

}
