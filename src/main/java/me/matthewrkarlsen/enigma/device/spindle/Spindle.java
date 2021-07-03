package me.matthewrkarlsen.enigma.device.spindle;

import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.PositionedWheel;

import java.util.Iterator;
import java.util.List;

public class Spindle implements Iterable<PositionedWheel> {

    private final List<PositionedWheel> wheels;

    public Spindle(List<PositionedWheel> wheels) {
        this.wheels = wheels;
    }

    public PositionedWheel get(int i) {
        return wheels.get(i);
    }

    @Override
    public Iterator<PositionedWheel> iterator() {
        return wheels.iterator();
    }
}
