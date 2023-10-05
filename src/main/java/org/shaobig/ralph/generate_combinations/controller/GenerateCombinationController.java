package org.shaobig.ralph.generate_combinations.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.shaobig.ralph.Letter;
import org.shaobig.ralph.generate_combinations.service.GenerateCombinationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
public class GenerateCombinationController {

    private final GenerateCombinationService generateCombinationService;

    @PostMapping(value = "/generate-combinations")
    public List<String> generateCombinations(@RequestBody List<Letter> letters) {
        return getGenerateCombinationService().generateCombinations(letters);
    }

}
