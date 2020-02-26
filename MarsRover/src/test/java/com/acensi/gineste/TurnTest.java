package com.acensi.gineste;

import com.acensi.gineste.Enum.DirectionEnum;
import com.acensi.gineste.model.Coordinates;
import com.acensi.gineste.model.Mars;
import com.acensi.gineste.model.Rover;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnTest {
    Coordinates coord;
    Mars board;

    @Before
    public void init() {
        coord = new Coordinates(1,3);
        board = new Mars(5,5);
    }

    @Test
    public void testTurnLeft() {
        Rover rover = new Rover(coord, DirectionEnum.NORTH, board);
        rover.turnLeft();
        Assert.assertEquals(DirectionEnum.WEST, rover.getFacing());
        rover.turnLeft();
        Assert.assertEquals(DirectionEnum.SOUTH, rover.getFacing());
        rover.turnLeft();
        Assert.assertEquals(DirectionEnum.EAST, rover.getFacing());
        rover.turnLeft();
        Assert.assertEquals(DirectionEnum.NORTH, rover.getFacing());
    }

    @Test
    public void testTurnRight() {
        Rover rover = new Rover(coord, DirectionEnum.NORTH, board);
        rover.turnRight();
        Assert.assertEquals(DirectionEnum.EAST, rover.getFacing());
        rover.turnRight();
        Assert.assertEquals(DirectionEnum.SOUTH, rover.getFacing());
        rover.turnRight();
        Assert.assertEquals(DirectionEnum.WEST, rover.getFacing());
        rover.turnRight();
        Assert.assertEquals(DirectionEnum.NORTH, rover.getFacing());
    }
}
