package me.matthewrkarlsen.enigma.device.spindle.rotor.positioned;

import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelWithRing;
import me.matthewrkarlsen.enigma.utilities.CharRange;
import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelIndex;

import java.util.ArrayList;
import java.util.List;

public class PositionedWheelImpl implements PositionedWheel {

    private final int slot;
    private final WheelWithRing wheel;
    private final PositionedWheel wheelToLeft;
    private final List<Character> baseChars;
    public List<Character> offsetChars;

    int position;

    public PositionedWheelImpl(int slot, RotorPosition position, WheelWithRing wheel, PositionedWheel wheelToLeft) {
        this.baseChars = new CharRange('A', 'Z').toList();
        this.slot = slot;
        this.position = position.getRotorPosition();
        this.wheel = wheel;
        this.wheelToLeft = wheelToLeft;
        this.offsetChars = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            int index = (i + this.position) % 26;
            Character e = baseChars.get(index);
            offsetChars.add(e);
        }
    }

    boolean doubleStepNextStep = false;

    @Override
    public void increment() {
        if(baseChars.get(position) == wheel.getTriggerChar()) {
            if(wheelToLeft != null) {
                wheelToLeft.increment();
            }
        }
        position = (position + 1) % 26;
        if(slot == 1 && baseChars.get(position) == wheel.getTriggerChar()) {
            doubleStepNextStep = true;
        }
    }

    @Override
    public void doubleStep() {
        if(doubleStepNextStep) {
            if(baseChars.get(position) == wheel.getTriggerChar()) {
                if(wheelToLeft != null) {
                    wheelToLeft.increment();
                }
            }
            position = (position + 1) % 26;
            doubleStepNextStep = false;
        }
    }

    @Override
    public SpatialIndex fromRight(SpatialIndex input) {
        WheelIndex wheelIndex = input.withPosition(position);
        WheelIndex i = wheel.fromRight(wheelIndex);
        SpatialIndex si = i.withPosition(position);
        return si;
    }

    @Override
    public SpatialIndex fromLeft(SpatialIndex input) {
        WheelIndex wheelIndex = input.withPosition(position);
        WheelIndex intVal = wheel.fromLeft(wheelIndex);
        SpatialIndex si = intVal.withPosition(position);
        return si;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return String.valueOf(baseChars.get(position));
    }
}
