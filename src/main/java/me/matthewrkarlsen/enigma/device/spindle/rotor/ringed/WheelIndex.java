package me.matthewrkarlsen.enigma.device.spindle.rotor.ringed;

import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.SpatialIndex;

public class WheelIndex {

    private final int index;

    public WheelIndex(int physicalPosition) {
        this.index = physicalPosition;
    }

    public static WheelIndex of(int physicalPosition) {
        return new WheelIndex(physicalPosition);
    }

    public SpatialIndex withPosition(int position, int settingsCount) {
        int i = (index - position);
        if(i < 0) {
            i += settingsCount;
        }
        return new SpatialIndex(i);
    }

    public WheelIndex withOffset(int offset, int settingsCount) {
        int i = (index - offset);
        if(i < 0) {
            i += settingsCount;
        }
        return new WheelIndex(i);
    }

    public int value() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof WheelIndex wheelIndex)) {
            return false;
        }
        return this.index == wheelIndex.index;
    }
}
