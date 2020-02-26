package com.acensi.gineste;

import com.acensi.gineste.Enum.DirectionEnum;
import com.acensi.gineste.model.Coordinates;
import com.acensi.gineste.model.Mars;
import com.acensi.gineste.model.Rover;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputTest {
    private String INPUT_PATH;

    @Before
    public void init() {
        INPUT_PATH = "src/test/resources/input.txt";
    }

    @Test
    public void testInput() {
        List<String> commands = new ArrayList<>();
        List<String> result = new ArrayList<>();
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
                result.add(rover.getPosition().getX() + " " + rover.getPosition().getY() + " " + rover.getFacing().getDirection());
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        Assert.assertEquals("1 3 N", result.get(0));
        Assert.assertEquals("5 1 E", result.get(1));
    }
}
