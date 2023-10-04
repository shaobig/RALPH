package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver;

import java.math.BigDecimal;

public class MultiplyFactorAlphabetSizeResolver extends FactorAlphabetSizeResolver {

    public MultiplyFactorAlphabetSizeResolver(BigDecimal factor, BigDecimal alphabetSize) {
        super(factor, alphabetSize);
    }

    @Override
    public int resolveSize() {
        return getFactor().multiply(getAlphabetSize()).intValue();
    }

}
