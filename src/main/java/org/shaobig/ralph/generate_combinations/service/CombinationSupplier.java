package org.shaobig.ralph.generate_combinations.service;

import org.shaobig.ralph.Letter;

import java.util.List;

public interface CombinationSupplier {

    List<String> supplyCombinations(List<Letter> letters);

}
