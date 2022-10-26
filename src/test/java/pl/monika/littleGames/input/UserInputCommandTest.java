package pl.monika.littleGames.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserInputCommandTest {

    @Test
    void shouldBuildCorrectUserInput() {

        String input = "WhatNumberIsIt-add_comment-aa";

        UserInputCommand userInputCommand = new UserInputCommand(input);

        Assertions.assertEquals("WhatNumberIsIt", userInputCommand.getCommand());
        Assertions.assertEquals("add_comment", userInputCommand.getAction().getValue());
        Assertions.assertLinesMatch(List.of("aa"), userInputCommand.getParam());
    }

    @Test
    void shouldBuildCorrectUserInputWithoutParams() {

        String input = "WhatNumberIsIt-show_comment";

        UserInputCommand userInputCommand = new UserInputCommand(input);

        Assertions.assertEquals("WhatNumberIsIt", userInputCommand.getCommand());
        Assertions.assertEquals("show_comment", userInputCommand.getAction().getValue());
        Assertions.assertLinesMatch(List.of(), userInputCommand.getParam());
    }


}