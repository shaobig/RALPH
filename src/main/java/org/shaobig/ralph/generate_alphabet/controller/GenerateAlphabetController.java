package org.shaobig.ralph.generate_alphabet.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.shaobig.ralph.Letter;
import org.shaobig.ralph.generate_alphabet.service.GenerateAlphabetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public class GenerateAlphabetController {

    private final GenerateAlphabetService generateAlphabetService;

    @GetMapping(path = "/")
    List<Letter> generateAlphabet() {
        return getGenerateAlphabetService().generateAlphabet();
    }

}
