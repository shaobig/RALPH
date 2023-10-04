package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public class IntegerMinMaxRandomGenerator implements MinMaxRandomGenerator<Integer> {

    private final Random random;

    public IntegerMinMaxRandomGenerator() {
        this.random = new Random();
    }

    @Override
    public Integer generateRandomNumber(Integer min, Integer max) {
        return getRandom().nextInt(max - min) + min;
    }

}
