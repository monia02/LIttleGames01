package pl.monika.littleGames;


import pl.monika.littleGames.handlers.CommandHandler;
import pl.monika.littleGames.handlers.HelpHandler;
import pl.monika.littleGames.handlers.QuitHandler;
import pl.monika.littleGames.handlers.WhatNumberIsItHandler;
import pl.monika.littleGames.input.UserInputCommand;
import pl.monika.littleGames.input.UserInputManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        try {
            String startMessage = Files.readString(Path.of("./StartMessage.txt"));
            System.out.println(startMessage);
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on start");
        }
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
