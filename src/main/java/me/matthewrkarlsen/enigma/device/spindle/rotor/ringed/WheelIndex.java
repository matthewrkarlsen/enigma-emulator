package me.matthewrkarlsen.enigma.device.spindle.rotor.ringed;

import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.SpatialIndex;

public class WheelIndex {

    private final int index;

    public WheelIndex(int physicalPosition) {
        this.index = physicalPosition;
    }

    public SpatialIndex withPosition(int position) {
        int i = (index - position);
        if(i < 0) {
            i += 26;
        }
        return new SpatialIndex(i);
    }

    public WheelIndex withOffset(int offset) {
        int i = (index - offset);
        if(i < 0) {
            i += 26;
        }
        return new WheelIndex(i);
    }

    public int value() {
        return index;
    }
}
