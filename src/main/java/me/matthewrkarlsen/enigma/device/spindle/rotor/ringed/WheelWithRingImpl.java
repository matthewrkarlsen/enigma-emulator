package me.matthewrkarlsen.enigma.device.spindle.rotor.ringed;

import me.matthewrkarlsen.enigma.device.spindle.rotor.basic.BasicWheel;
import me.matthewrkarlsen.enigma.utilities.CharRange;

import java.util.ArrayList;
import java.util.List;

public class WheelWithRingImpl implements WheelWithRing {

    private final BasicWheel basicWheel;
    private final int offset;

    public List<Character> baseChars;
    public List<Character> offsetChars;

    private final Character triggerChar;

    public WheelWithRingImpl(BasicWheel basicWheel, int offset, Character defaultTriggerChar) {
        this.baseChars = new CharRange('A', 'Z').toList();
        this.basicWheel = basicWheel;
        this.offset = offset;
        this.offsetChars = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            offsetChars.add(baseChars.get((i + offset) % 26));
        }
        int dtcIdx = baseChars.indexOf(defaultTriggerChar);
        int tcIdx = dtcIdx + offset;
        triggerChar = offsetChars.get(tcIdx);
    }

    @Override
    public WheelIndex fromRight(WheelIndex input) {
        WheelIndex inputMod = input.withOffset(offset);
        WheelIndex i = basicWheel.fromRight(inputMod);
        return i;
    }

    @Override
    public WheelIndex fromLeft(WheelIndex input) {
        WheelIndex intVal = basicWheel.fromLeft(input);
        WheelIndex i = intVal.withOffset(offset);
        return i;
    }

    @Override
    public Character getTriggerChar() {
        return triggerChar;
    }
}
