package com.acensi.gineste;

import com.acensi.gineste.Enum.DirectionEnum;
import com.acensi.gineste.model.Coordinates;
import com.acensi.gineste.model.Mars;
import com.acensi.gineste.model.Rover;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        String INPUT_PATH = null;
        if (args.length != 0) {
            INPUT_PATH = args[0];
        } else {
            System.err.println("[ERROR]: Please give an input text file as argument");
        }

        if (INPUT_PATH != null) {
            List<String> commands = new ArrayList<>();
            try {
                // readAllLines bien pour des petites files comme pour cet exercice
                // Pour un programme plus important il est recommandé d'utiliser plutot un bufferReader (meilleur niveau perf)
                commands = Files.readAllLines(Paths.get(INPUT_PATH));


                final String[] boardDefinition = commands.get(0).split("\\s");
                commands.remove(0);
                final Mars board = new Mars(Integer.parseInt(boardDefinition[0]), Integer.parseInt(boardDefinition[1]));

                for (int i = 0; i < commands.size() / 2; i++) {
                    String[] roverPosition = commands.get(i * 2).split("\\s");
                    Coordinates coord = new Coordinates(Integer.parseInt(roverPosition[0]), Integer.parseInt(roverPosition[1]));
                    Rover rover = new Rover(coord, DirectionEnum.fromCode(roverPosition[2]), board);

                    rover.process(commands.get((i * 2) + 1));
                    rover.printPosition();
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
