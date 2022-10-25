package pl.monika.littleGames.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.monika.littleGames.model.WhatNumberIsItComment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WhatNumberIsItDao {
    private static final Logger LOG = Logger.getLogger(WhatNumberIsItDao.class.getName());
//TODO
    /*
    co może pójśc nie tak:
wyjdź z gry
wydzielenie osobnej metody na pobieranie komentarzy
    if może przerobić na switch ?
    zamykanie plików tekstowych
    mapping
     */

    private ObjectMapper objectMapper;
    public WhatNumberIsItDao() {
        this.objectMapper = new ObjectMapper();
    }

    public void play() {
        try {
            LOG.info("Losowanie liczby z zakresu od 0 do 100. Zgadnij jaka to liczba!");
            Scanner scanner = new Scanner(System.in);
            Random num = new Random();
            int number = num.nextInt(101);
            boolean goal = false;
            int counter = 0;
            while (!goal) {
                int userChoice = scanner.nextInt();
                counter++;
                if (userChoice > 100 || userChoice < 0) {
                    LOG.info("Liczba wykracza poza zakres. Spróbuj jeszcze raz.");
                } else if (userChoice < number) {
                    LOG.info("Za mała liczba... Spróbuj jeszcze raz");
                } else if (userChoice > number) {
                    LOG.info("Za duża liczba.. Spróbuj jeszcze raz");
                } else if (userChoice == number) {
                    LOG.info("Gratulacje! Udało Ci się za " + counter + " razem!");
                    goal = true;
                } else {
                    LOG.info("Nieznany bład");
                }
            }
        } catch (InputMismatchException e) {
            LOG.log(Level.WARNING, "Error on play", e);
        }
    }

    public String showDescription() {
        try {
            String description = Files.readString(Paths.get("./WhatNumberIsItDescription.txt"));
            return description;
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on showDescription", e);
            return "";
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
            LOG.log(Level.WARNING, "Error on findAllComments",e);
            return new ArrayList<>();
        }
    }

    public void addComment(WhatNumberIsItComment whatNumberIsItComment) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("./WhatNumberIsItComments.txt"));
            lines.add(whatNumberIsItComment.getName());
            Files.writeString(Paths.get("./WhatNumberIsItComments.txt"), String.join("\n", lines));
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on addComment");
        }

    }

    public void removeComment(WhatNumberIsItComment whatNumberIsItComment) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("./WhatNumberIsItComments.txt"));
            lines.remove(whatNumberIsItComment.getName());
            Files.writeString(Paths.get("./WhatNumberIsItComments.txt"), String.join("\n", lines));
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on addComment");
        }
    }
}
