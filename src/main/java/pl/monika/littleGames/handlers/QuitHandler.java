package pl.monika.littleGames.handlers;


import pl.monika.littleGames.QuitLittleGamesException;
import pl.monika.littleGames.input.UserInputCommand;

public class QuitHandler extends BaseCommandHandler {
    public static final String COMMAND_NAME = "quit";
    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
    @Override
    public String handle(UserInputCommand command) {
        throw new QuitLittleGamesException();

    }
}

