package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver;

import lombok.AccessLevel;
import lombok.Getter;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random.MinMaxRandomGenerator;

@Getter(value = AccessLevel.PACKAGE)
public class FactorIntegerMinMaxRandomAlphabetSizeResolver extends MinMaxRandomAlphabetSizeResolver<Integer> {

    private final FactorAlphabetSizeResolver minFactorAlphabetSizeResolver;
    private final FactorAlphabetSizeResolver maxFactorAlphabetSizeResolver;

    public FactorIntegerMinMaxRandomAlphabetSizeResolver(MinMaxRandomGenerator<Integer> integerMinMaxRandomGenerator, FactorAlphabetSizeResolver minFactorAlphabetSizeResolver, FactorAlphabetSizeResolver maxFactorAlphabetSizeResolver) {
        super(integerMinMaxRandomGenerator);
        this.minFactorAlphabetSizeResolver = minFactorAlphabetSizeResolver;
        this.maxFactorAlphabetSizeResolver = maxFactorAlphabetSizeResolver;
    }

    @Override
    public int resolveSize() {
        return getMinMaxRandomGenerator().generateRandomNumber(getMinFactorAlphabetSizeResolver().resolveSize(), getMaxFactorAlphabetSizeResolver().resolveSize());
    }

}
