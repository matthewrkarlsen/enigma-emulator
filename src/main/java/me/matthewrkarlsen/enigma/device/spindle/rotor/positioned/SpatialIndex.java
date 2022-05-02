package me.matthewrkarlsen.enigma.device.spindle.rotor.positioned;

import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelIndex;

public class SpatialIndex {

    private final int index;

    public SpatialIndex(int index) {
        this.index = index;
    }

    public static SpatialIndex of(int index) {
        return new SpatialIndex(index);
    }

    public WheelIndex withPosition(int position, int settingsCount) {
        int i = (index + position) % settingsCount;
        return new WheelIndex(i);
    }

    public int value() {
        return index;
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof SpatialIndex spatialIndex)) {
            return false;
        }
        return this.index == spatialIndex.index;
    }
}
