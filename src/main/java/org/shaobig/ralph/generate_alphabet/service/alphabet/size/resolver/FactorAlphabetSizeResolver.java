package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public abstract class FactorAlphabetSizeResolver implements AlphabetSizeResolver {

    private final BigDecimal factor;
    private final BigDecimal alphabetSize;

}
