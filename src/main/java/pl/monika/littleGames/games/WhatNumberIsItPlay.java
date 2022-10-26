package pl.monika.littleGames.games;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WhatNumberIsItPlay {

    private static Logger LOG = Logger.getLogger(WhatNumberIsItPlay.class.getName());

    public void play() {
        try {
            LOG.info("Losowanie liczby z zakresu od 0 do 100. Zgadnij jaka to liczba!");
            Scanner scanner = new Scanner(System.in);
            Random num = new Random();
            Integer number = num.nextInt(101);
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
}
