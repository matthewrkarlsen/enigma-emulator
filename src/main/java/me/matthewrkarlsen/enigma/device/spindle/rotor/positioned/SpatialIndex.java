package me.matthewrkarlsen.enigma.device.spindle.rotor.positioned;

import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelIndex;

public class SpatialIndex {

    private final int index;

    public SpatialIndex(int index) {
        this.index = index;
    }

    public WheelIndex withPosition(int position) {
        int i = (index + position) % 26;
        return new WheelIndex(i);
    }

    public int value() {
        return index;
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }
}
