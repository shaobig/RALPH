package org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Comparator;

@Component
public class ProxyMinMaxRandomGeneratorComparator<T extends Number> implements Comparator<T> {

    @Override
    public int compare(T min, T max) {
        return BigDecimal.valueOf(min.doubleValue()).compareTo(BigDecimal.valueOf(max.doubleValue()));
    }

}
