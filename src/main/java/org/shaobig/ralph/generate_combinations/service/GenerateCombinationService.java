package org.shaobig.ralph.generate_combinations.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.shaobig.ralph.Letter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public class GenerateCombinationService {

    private final StreamReduceCombinationSupplier streamReduceCombinationSupplier;

    public List<String> generateCombinations(List<Letter> letters) {
        return getStreamReduceCombinationSupplier().supplyCombinations(letters);
    }

}
