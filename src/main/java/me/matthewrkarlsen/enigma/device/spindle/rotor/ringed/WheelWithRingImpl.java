package me.matthewrkarlsen.enigma.device.spindle.rotor.ringed;

import me.matthewrkarlsen.enigma.device.spindle.rotor.basic.Wheel;

public class WheelWithRingImpl implements WheelWithRing {

    private final Wheel basicWheel;
    private final int offset;

    public String baseChars;
    public String offsetChars;

    private final Character triggerChar;

    public WheelWithRingImpl(String alphabet, Wheel basicWheel, int offset, Character defaultTriggerChar) {
        this.baseChars = alphabet;
        this.basicWheel = basicWheel;
        this.offset = offset;
        char[] offsetCharArray = new char[alphabet.length()];
        for(int i = 0; i < alphabet.length(); i++) {
            offsetCharArray[i] = (baseChars.charAt((i + offset) % alphabet.length()));
        }
        int dtcIdx = baseChars.indexOf(defaultTriggerChar);
        int tcIdx = dtcIdx + offset;
        triggerChar = offsetCharArray[tcIdx];
        this.offsetChars = new String(offsetCharArray);
    }

    @Override
    public WheelIndex fromRight(WheelIndex input) {
        WheelIndex inputMod = input.withOffset(offset, baseChars.length());
        WheelIndex i = basicWheel.convertOutwardInput(inputMod);
        return i;
    }

    @Override
    public WheelIndex fromLeft(WheelIndex input) {
        WheelIndex intVal = basicWheel.convertReturnInput(input);
        WheelIndex i = intVal.withOffset(offset, baseChars.length());
        return i;
    }

    @Override
    public Character getTriggerChar() {
        return triggerChar;
    }
}
