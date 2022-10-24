package pl.handlers;


import pl.QuitLittleGamesException;
import pl.input.UserInputCommand;

public class QuitHandler extends BaseCommandHandler {
    public static final String COMMAND_NAME = "quit";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        throw new QuitLittleGamesException();

    }
}

