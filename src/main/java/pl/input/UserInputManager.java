package pl.input;

import java.util.Scanner;

public class UserInputManager {

    private Scanner scanner;

    public UserInputManager() {
        scanner = new Scanner(System.in);
    }

    public UserInputCommand nextCommand() {// zwrócenie komendy od user

        return new UserInputCommand(scanner.nextLine());
    }
}


