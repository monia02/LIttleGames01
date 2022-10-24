package pl.dao;

import pl.model.WhatNumberIsItComment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WhatNumberIsItDao {


    public void play() {
        System.out.println("Losowanie liczby z zakresu od 0 do 100. Zgadnij jaka to liczba!");
        Scanner scanner = new Scanner(System.in);


        Random num = new Random();
        int number = num.nextInt(101);

        boolean goal = false;

        while (!goal) {

            int userChoice = scanner.nextInt();


            if (userChoice < number) {
                System.out.println("Za mała liczba... Spróbuj jeszcze raz");

            } else if (userChoice > number) {
                System.out.println("Za duża liczba.. Spróbuj jeszcze raz");

            } else if (userChoice == number) {
                System.out.println("Gratulacje!");
                goal = true;

            } else {
                System.out.println("Nieznany bład");
            }
        }
    }

    public String showDescription() {
        String description = null;
        try {
            description = Files.readString(Paths.get("./WhatNumberIsItDescription.txt"));
            return description;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


    public List<WhatNumberIsItComment> findAllComments() {


        try {

            List<String> lines = Files.readAllLines(Paths.get("./WhatNumberIsItComments.txt"));
            List<WhatNumberIsItComment> comments = new ArrayList<>();
            for (String line : lines) {
                comments.add(new WhatNumberIsItComment(line));

            }

            return comments;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void addComment(WhatNumberIsItComment whatNumberIsItComment) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("./WhatNumberIsItComments.txt"));

            lines.add(whatNumberIsItComment.getName());
            Files.writeString(Paths.get("./WhatNumberIsItComments.txt"), String.join("\n", lines));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
