package org.shaobig.ralph.generate_alphabet.service.alphabet.composer.shuffler;

import java.util.List;

public interface ListShuffler<T> {

    List<T> shuffleList(List<T> sourceList);

}
