package org.shaobig.ralph.generate_alphabet.service.alphabet.composer.shuffler;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CollectionUtilityListShuffler<T> implements ListShuffler<T> {

    @Override
    public List<T> shuffleList(List<T> sourceList) {
        List<T> shuffledList = new ArrayList<>(sourceList);
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

}
