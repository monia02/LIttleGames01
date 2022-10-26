package pl.monika.littleGames.input;


import pl.monika.littleGames.Action;

import java.util.ArrayList;
import java.util.List;

public class UserInputCommand {

    private String command;
    private Action action;
    private List<String> param;

    public UserInputCommand(String line) {

        if (line != null) {
            String[] array = line.split("\\-");
            if (array.length > 0) {
                command = array[0];
            }
            if (array.length > 1) {
                action = Action.of(array[1]);
            }
            param = new ArrayList<>();
            for (int i = 2; i < array.length; i++) {
                param.add(array[i]);

            }
        }
    }


    @Override
    public String toString() {
        return "UserInputCommand{" +
                "command='" + command + '\'' +
                ", action=" + action +
                ", param=" + param +
                '}';
    }

    public String getCommand() {
        return command;
    }

    public Action getAction() {
        return action;
    }

    public List<String> getParam() {
        return param;
    }
}

