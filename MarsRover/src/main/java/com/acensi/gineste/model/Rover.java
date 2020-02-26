package com.acensi.gineste.model;

import com.acensi.gineste.Enum.DirectionEnum;
import com.acensi.gineste.exception.OutOfBoundException;

public class Rover {

    private Coordinates position;
    private DirectionEnum facing;
    private Mars board;

    public Rover(Coordinates position, DirectionEnum facing, Mars board){
        this.position = position;
        this.facing = facing;
        this.board = board;
    }

    public void setWholePosition(int x, int y, DirectionEnum facing){
        this.position.setX(x);
        this.position.setY(y);
        this.facing = facing;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public Mars getBoard() {
        return board;
    }

    public void setBoard(Mars board) {
        this.board = board;
    }

    public void setFacing(DirectionEnum facing) {
        this.facing = facing;
    }

    public DirectionEnum getFacing() {
        return facing;
    }

    public void printPosition(){
        System.out.println(position.getX() + " " + position.getY() + " " + this.facing.getDirection());
    }

    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++ ){
            process(commands.charAt(idx));
        }
    }

    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        } else {
            System.out.println("Rover doesn't know this command!");
        }
    }

    public void move() {
        if (facing == DirectionEnum.NORTH && this.position.getY() < board.getHeight())
        {
            this.position.setY(this.position.getY()+1);
        }
        else if (facing == DirectionEnum.EAST && this.position.getX() < board.getLength())
        {
            this.position.setX(this.position.getX()+1);
        }
        else if (facing == DirectionEnum.SOUTH && this.position.getY() > 0)
        {
            this.position.setY(this.position.getY()-1);
        }
        else if (facing == DirectionEnum.WEST && this.position.getX() > 0)
        {
            this.position.setX(this.position.getX()-1);
        } else {
            throw new OutOfBoundException();
        }
    }
    public void turnLeft() {
        if (facing != null) {
            switch (facing) {
                case NORTH:
                    facing = DirectionEnum.WEST;
                    break;
                case EAST:
                    facing = DirectionEnum.NORTH;
                    break;
                case SOUTH:
                    facing = DirectionEnum.EAST;
                    break;
                case WEST:
                    facing = DirectionEnum.SOUTH;
                    break;
            }
        }
    }
    public void turnRight() {
        if (facing != null) {
            switch (facing) {
                case NORTH:
                    facing = DirectionEnum.EAST;
                    break;
                case EAST:
                    facing = DirectionEnum.SOUTH;
                    break;
                case SOUTH:
                    facing = DirectionEnum.WEST;
                    break;
                case WEST:
                    facing = DirectionEnum.NORTH;
                    break;
            }
        }
    }
}