package pl.handlers;

import pl.dao.WhatNumberIsItDao;
import pl.input.UserInputCommand;
import pl.model.WhatNumberIsItComment;

import java.util.List;

public class WhatNumberIsItHandler extends BaseCommandHandler {


    public static final String COMMAND_NAME = "WhatNumberIsIt";

    private WhatNumberIsItDao whatNumberIsItDao;

    public WhatNumberIsItHandler() {
        whatNumberIsItDao = new WhatNumberIsItDao();
    }


    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {

        switch (command.getAction()) {
            case PLAY:
                whatNumberIsItDao.play();
                break;
            case DESCRIPTION:
                System.out.println("Descrription:");
                String description = whatNumberIsItDao.showDescription();
                System.out.println(description);
                break;

            case SHOW_COMMENTS:
                System.out.println("Comments:");
                List<WhatNumberIsItComment> comments = whatNumberIsItDao.findAllComments();
                comments.forEach(System.out::println);
                break;
            case ADD_COMMENT:
                System.out.println("Add comment");
                String comment = command.getParam().get(0);
                whatNumberIsItDao.addComment(new WhatNumberIsItComment(comment));
                break;
            default: {
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s",
                        command.getAction(), command.getCommand()));
            }

        }

    }
}
