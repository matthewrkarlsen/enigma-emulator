package me.matthewrkarlsen.enigma.device.spindle.rotor.positioned;

import static java.lang.String.format;

public class RotorPosition {

    private int rotorPosition;
    private final int numberOfSettings;

    public RotorPosition(int rotorPosition, int numberOfSettings) {
        if(rotorPosition >= numberOfSettings) {
            throw new IllegalArgumentException(format("Invalid position: %s", rotorPosition));
        }
        this.rotorPosition = rotorPosition;
        this.numberOfSettings = numberOfSettings;
    }

    public int getRotorPosition() {
        return this.rotorPosition;
    }

    public void increment() {
        this.rotorPosition = (rotorPosition + 1) % numberOfSettings;
    }
}
