package com.acensi.gineste.Enum;

public enum DirectionEnum {

    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private String direction;

    DirectionEnum(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public static DirectionEnum fromCode(String code) {
        if (code == null) {
            return null;
        } else {
            for (DirectionEnum d : DirectionEnum.values()) {
                if (d.getDirection().equals(code)) {
                    return d;
                }
            }
        }
        throw new IllegalArgumentException(code);
    }
}
