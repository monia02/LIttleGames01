package pl.monika.littleGames.handlers;

import pl.monika.littleGames.dao.WhatNumberIsItDao;
import pl.monika.littleGames.games.WhatNumberIsItPlay;
import pl.monika.littleGames.input.UserInputCommand;
import pl.monika.littleGames.model.WhatNumberIsItComment;

import java.util.List;
import java.util.logging.Logger;

public class WhatNumberIsItHandler extends BaseCommandHandler {
    private static Logger LOG = Logger.getLogger(WhatNumberIsItHandler.class.getName());
    public static final String COMMAND_NAME = "WhatNumberIsIt";
    private WhatNumberIsItDao whatNumberIsItDao;
    private WhatNumberIsItPlay whatNumberIsItPlay;

    public WhatNumberIsItHandler() {
        whatNumberIsItDao = new WhatNumberIsItDao();
        whatNumberIsItPlay = new WhatNumberIsItPlay();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public String handle(UserInputCommand command) {
        if (command.getAction() == null) {
            throw new IllegalArgumentException("Action can not be null.");
        }
        switch (command.getAction()) {
            case PLAY:
                LOG.info("Start..");
                whatNumberIsItPlay.play();
                break;
            case DESCRIPTION:
                LOG.info("Descrription:");
                String description = whatNumberIsItDao.showDescription();
                System.out.println(description);
                break;
            case SHOW_COMMENTS:
                LOG.info("Comments:");
                List<WhatNumberIsItComment> comments = whatNumberIsItDao.findAllComments();
                comments.forEach(System.out::println);
                break;
            case ADD_COMMENT:
                LOG.info("Add comment");
                String comment = command.getParam().get(0);
                whatNumberIsItDao.addComment(new WhatNumberIsItComment(comment));
                break;
            case REMOVE_COMMENT:
                LOG.info("Remove comment");
                String commentToRemove = command.getParam().get(0);
                whatNumberIsItDao.removeComment(new WhatNumberIsItComment(commentToRemove));
                break;
            default: {
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s",
                        command.getAction(), command.getCommand()));
            }
        }
        return null;
    }
}
