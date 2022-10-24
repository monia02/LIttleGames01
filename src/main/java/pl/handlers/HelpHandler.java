package pl.handlers;


import pl.input.UserInputCommand;

public class HelpHandler extends BaseCommandHandler {
    public static final String COMMAND_NAME = "help";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        System.out.println("Help:");
        System.out.println("Allowed commands: help, quit, WhatNumberIsIt");
        System.out.println("Allowed actions:" +
                "\nplay" +
                "\nshow_comments" +
                "\nadd_comment" +
                "\ndescription");
        System.out.println("Command pattern: <command>.<action>.<param>");
        System.out.println("Example: WhatNumberIsIt.add_comments.Example comment");
        System.out.println("Allowed games: " +
                "WhatNumberIsIt");


    }


}

