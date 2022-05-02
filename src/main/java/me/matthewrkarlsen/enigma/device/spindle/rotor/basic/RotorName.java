package me.matthewrkarlsen.enigma.device.spindle.rotor.basic;

public class RotorName {

    private final String rotorName;

    public RotorName(String rotorName) {
        this.rotorName = rotorName;
    }

    @Override
    public String toString() {
        return this.rotorName;
    }
}
