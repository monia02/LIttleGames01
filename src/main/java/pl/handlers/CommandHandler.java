package pl.handlers;


import pl.input.UserInputCommand;

public interface CommandHandler {

    void handle(UserInputCommand command);

    boolean supports(String name);
}
