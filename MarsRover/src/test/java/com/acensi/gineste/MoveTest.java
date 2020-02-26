package com.acensi.gineste;

import com.acensi.gineste.Enum.DirectionEnum;
import com.acensi.gineste.exception.OutOfBoundException;
import com.acensi.gineste.model.Coordinates;
import com.acensi.gineste.model.Mars;
import com.acensi.gineste.model.Rover;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoveTest {
    Coordinates coord;
    Mars board;

    @Before
    public void init() {
        coord = new Coordinates(1,3);
        board = new Mars(5,5);
    }

    @Test(expected = OutOfBoundException.class)
    public void testOutOfBoundException() {
        coord.setX(5);
        Rover rover = new Rover(coord, DirectionEnum.EAST, board);
        rover.move();
    }

    @Test
    public void testMoveToNorth() {
        Rover rover = new Rover(coord, DirectionEnum.NORTH, board);
        rover.move();
        Assert.assertEquals(1, rover.getPosition().getX());
        Assert.assertEquals(4, rover.getPosition().getY());
    }

    @Test
    public void testMoveToWest() {
        Rover rover = new Rover(coord, DirectionEnum.WEST, board);
        rover.move();
        Assert.assertEquals(0, rover.getPosition().getX());
        Assert.assertEquals(3, rover.getPosition().getY());
    }

    @Test
    public void testMoveToSouth() {
        Rover rover = new Rover(coord, DirectionEnum.SOUTH, board);
        rover.move();
        Assert.assertEquals(1, rover.getPosition().getX());
        Assert.assertEquals(2, rover.getPosition().getY());
    }

    @Test
    public void testMoveToEast() {
        Rover rover = new Rover(coord, DirectionEnum.EAST, board);
        rover.move();
        Assert.assertEquals(2, rover.getPosition().getX());
        Assert.assertEquals(3, rover.getPosition().getY());
    }
}
