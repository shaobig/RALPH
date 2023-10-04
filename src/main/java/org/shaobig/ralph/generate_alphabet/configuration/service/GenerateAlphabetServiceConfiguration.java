package org.shaobig.ralph.generate_alphabet.configuration.service;

import org.shaobig.ralph.generate_alphabet.LetterType;
import org.shaobig.ralph.generate_alphabet.repository.AlphabetProvider;
import org.shaobig.ralph.generate_alphabet.repository.ConsonantAlphabetProvider;
import org.shaobig.ralph.generate_alphabet.repository.VowelAlphabetProvider;
import org.shaobig.ralph.generate_alphabet.service.alphabet.composer.IntegerLetterRandomAlphabetComposer;
import org.shaobig.ralph.generate_alphabet.service.alphabet.composer.IntegerRandomAlphabetComposer;
import org.shaobig.ralph.generate_alphabet.service.alphabet.composer.LetterRandomAlphabetComposer;
import org.shaobig.ralph.generate_alphabet.service.alphabet.composer.shuffler.ListShuffler;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.FactorAlphabetSizeResolver;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.FactorIntegerMinMaxRandomAlphabetSizeResolver;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.MultiplyFactorAlphabetSizeResolver;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random.IntegerMinMaxRandomGenerator;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random.ProxyMinMaxRandomGenerator;
import org.shaobig.ralph.generate_alphabet.service.alphabet.size.resolver.random.ProxyMinMaxRandomGeneratorComparator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class GenerateAlphabetServiceConfiguration {

    private static final BigDecimal MIN_VOWEL_FACTOR = new BigDecimal("0.06");
    private static final BigDecimal MAX_VOWEL_FACTOR = new BigDecimal("0.36");
    private static final BigDecimal MIN_CONSONANT_FACTOR = new BigDecimal("0.03");
    private static final BigDecimal MAX_CONSONANT_FACTOR = new BigDecimal("0.3");

    public static FactorAlphabetSizeResolver getFactorAlphabetSizeResolver(BigDecimal factor, AlphabetProvider alphabetProvider) {
        return new MultiplyFactorAlphabetSizeResolver(factor, BigDecimal.valueOf(alphabetProvider.provideAlphabet().size()));
    }

    @Bean
    public ProxyMinMaxRandomGenerator<Integer> integerProxyMinMaxRandomGenerator(ProxyMinMaxRandomGeneratorComparator<Integer> integerProxyMinMaxRandomGeneratorComparator, IntegerMinMaxRandomGenerator integerMinMaxRandomGenerator) {
        return new ProxyMinMaxRandomGenerator<>(integerProxyMinMaxRandomGeneratorComparator, integerMinMaxRandomGenerator);
    }

    @Bean
    public FactorAlphabetSizeResolver minVowelFactorAlphabetSizeResolver(VowelAlphabetProvider vowelAlphabetProvider) {
        return GenerateAlphabetServiceConfiguration.getFactorAlphabetSizeResolver(MIN_VOWEL_FACTOR, vowelAlphabetProvider);
    }

    @Bean
    public FactorAlphabetSizeResolver maxVowelFactorAlphabetSizeResolver(VowelAlphabetProvider vowelAlphabetProvider) {
        return GenerateAlphabetServiceConfiguration.getFactorAlphabetSizeResolver(MAX_VOWEL_FACTOR, vowelAlphabetProvider);
    }

    @Bean
    public FactorAlphabetSizeResolver minConsonantFactorAlphabetSizeResolver(ConsonantAlphabetProvider consonantAlphabetProvider) {
        return GenerateAlphabetServiceConfiguration.getFactorAlphabetSizeResolver(MIN_CONSONANT_FACTOR, consonantAlphabetProvider);
    }

    @Bean
    public FactorAlphabetSizeResolver maxConsonantFactorAlphabetSizeResolver(ConsonantAlphabetProvider consonantAlphabetProvider) {
        return GenerateAlphabetServiceConfiguration.getFactorAlphabetSizeResolver(MAX_CONSONANT_FACTOR, consonantAlphabetProvider);
    }

    @Bean
    public FactorIntegerMinMaxRandomAlphabetSizeResolver vowelFactorIntegerMinMaxRandomAlphabetSizeResolver(ProxyMinMaxRandomGenerator<Integer> integerProxyMinMaxRandomGenerator, FactorAlphabetSizeResolver minVowelFactorAlphabetSizeResolver, FactorAlphabetSizeResolver maxVowelFactorAlphabetSizeResolver) {
        return new FactorIntegerMinMaxRandomAlphabetSizeResolver(integerProxyMinMaxRandomGenerator, minVowelFactorAlphabetSizeResolver, maxVowelFactorAlphabetSizeResolver);
    }

    @Bean
    public FactorIntegerMinMaxRandomAlphabetSizeResolver consonantFactorIntegerMinMaxRandomAlphabetSizeResolver(ProxyMinMaxRandomGenerator<Integer> integerProxyMinMaxRandomGenerator, FactorAlphabetSizeResolver minConsonantFactorAlphabetSizeResolver, FactorAlphabetSizeResolver maxConsonantFactorAlphabetSizeResolver) {
        return new FactorIntegerMinMaxRandomAlphabetSizeResolver(integerProxyMinMaxRandomGenerator, minConsonantFactorAlphabetSizeResolver, maxConsonantFactorAlphabetSizeResolver);
    }

    @Bean
    public IntegerRandomAlphabetComposer vowelIntegerRandomAlphabetComposer(VowelAlphabetProvider vowelAlphabetProvider, FactorIntegerMinMaxRandomAlphabetSizeResolver vowelFactorIntegerMinMaxRandomAlphabetSizeResolver, ListShuffler<String> stringListShuffler) {
        return new IntegerRandomAlphabetComposer(vowelAlphabetProvider, vowelFactorIntegerMinMaxRandomAlphabetSizeResolver, stringListShuffler);
    }

    @Bean
    public IntegerRandomAlphabetComposer consonantIntegerRandomAlphabetComposer(ConsonantAlphabetProvider consonantAlphabetProvider, FactorIntegerMinMaxRandomAlphabetSizeResolver consonantFactorIntegerMinMaxRandomAlphabetSizeResolver, ListShuffler<String> stringListShuffler) {
        return new IntegerRandomAlphabetComposer(consonantAlphabetProvider, consonantFactorIntegerMinMaxRandomAlphabetSizeResolver, stringListShuffler);
    }

    @Bean
    public IntegerLetterRandomAlphabetComposer vowelIntegerLetterRandomAlphabetUniversalComposer(IntegerRandomAlphabetComposer vowelIntegerRandomAlphabetComposer) {
        return new IntegerLetterRandomAlphabetComposer(vowelIntegerRandomAlphabetComposer, LetterType.VOWEL);
    }

    @Bean
    public IntegerLetterRandomAlphabetComposer consonantIntegerLetterRandomAlphabetUniversalComposer(IntegerRandomAlphabetComposer consonantIntegerRandomAlphabetComposer) {
        return new IntegerLetterRandomAlphabetComposer(consonantIntegerRandomAlphabetComposer, LetterType.CONSONANT);
    }

    @Bean
    public List<LetterRandomAlphabetComposer<Integer>> letterRandomAlphabetComposers(IntegerLetterRandomAlphabetComposer vowelIntegerLetterRandomAlphabetUniversalComposer, IntegerLetterRandomAlphabetComposer consonantIntegerLetterRandomAlphabetUniversalComposer) {
        return List.of(vowelIntegerLetterRandomAlphabetUniversalComposer, consonantIntegerLetterRandomAlphabetUniversalComposer);
    }

}
