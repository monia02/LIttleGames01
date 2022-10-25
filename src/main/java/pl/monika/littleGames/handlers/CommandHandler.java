package pl.monika.littleGames.handlers;


import pl.monika.littleGames.input.UserInputCommand;

public interface CommandHandler {

    String handle(UserInputCommand command);

    boolean supports(String name);
}
