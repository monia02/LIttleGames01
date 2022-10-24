package pl;


import pl.handlers.CommandHandler;
import pl.handlers.HelpHandler;
import pl.handlers.QuitHandler;
import pl.handlers.WhatNumberIsItHandler;
import pl.input.UserInputCommand;
import pl.input.UserInputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartGame {

    private static Logger LOG = Logger.getLogger(StartGame.class.getName());


    public static void main(String[] args) {


        new StartGame().start();

    }

    private void start() {
        System.out.println("Witaj!" +
                "\nOto lista gier, w które możesz zagrać: " +
                "\n-> WhatNumberIsIt?" +
                "\n" +
                "\nWpisz help by uzyskać więcej informacji" +
                "\nMiłej zabawy!");

        boolean appLoop = true;


        UserInputManager userInputManager = new UserInputManager();

        List<CommandHandler> handlers = new ArrayList<>();
        handlers.add(new HelpHandler());
        handlers.add(new QuitHandler());
        handlers.add(new WhatNumberIsItHandler());


        while (appLoop) {

            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();

                Optional<CommandHandler> currentHandler = Optional.empty();
                for (CommandHandler handler : handlers) {
                    if (handler.supports(userInputCommand.getCommand())) {
                        currentHandler = Optional.of(handler);
                        break;
                    }

                }
                currentHandler
                        .orElseThrow(() -> new IllegalArgumentException("Unknown handler: " + userInputCommand.getCommand()))
                        .handle(userInputCommand);
            } catch (QuitLittleGamesException e) {
                System.out.println("Bye!");
                appLoop = false;
            } catch (IllegalArgumentException e) {
                LOG.log(Level.WARNING, "Validation exception", e.getMessage());
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Unknown error", e);
            }

        }


    }
}
