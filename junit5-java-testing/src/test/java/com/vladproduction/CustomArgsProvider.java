package com.vladproduction;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CustomArgsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("MU", 1878, "Old Trafford", "England"),
                Arguments.of("RM", 1902, "Estadio Santiago Bernabéu", "Spain"),
                Arguments.of("DK", 1927, "Dynamo Stadium named after Valeriy Lobanovskyi", "Ukraine")
        );
    }
}
