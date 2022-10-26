package pl.monika.littleGames.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputCommandTest {

    @Test
    void shouldBuildCorrectUserInput() {
        //given
        String input = "WhatNumberIsIt.add_comment.aa";
        //when
        UserInputCommand userInputCommand = new UserInputCommand(input);
        //then
        Assertions.assertEquals("WhatNumberIsIt", userInputCommand.getCommand());
        Assertions.assertEquals("add_comment", userInputCommand.getAction());
        Assertions.assertLinesMatch(List.of("aa"), userInputCommand.getParam());
    }
}