package pl.monika.littleGames.handlers;


import pl.monika.littleGames.input.UserInputCommand;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelpHandler extends BaseCommandHandler {

    private static Logger LOG = Logger.getLogger(HelpHandler.class.getName());
    public static final String COMMAND_NAME = "help";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String handle(UserInputCommand command) {
        try {
            String helpText = Files.readString(Path.of("./Help.txt"));
            System.out.println(helpText);
            return "";
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Something went wrong.",e);
            return null;
        }
    }


}

