package com.company;

import java.util.Scanner;

public class Main {

    static boolean isWorking = true;
    static StopWatch sw;

    public static void main(String[] args) {
        sw = new StopWatch();
        readCommands();
    }

    static public void readCommands() {
        while (isWorking) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("start")) {
                sw.start();
            }
            if (command.equals("stop")) {
                sw.stop();
            }
            if (command.equals("pause")) {
                sw.pause();
            }
            if (command.equals("resume")) {
                sw.resume();
            }
            if (command.equals("close")) {
                sw.stop();
                isWorking = false;
            }
        }
    }
}

