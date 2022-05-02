package me.matthewrkarlsen.enigma.device.spindle.rotor.positioned;

import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelIndex;
import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelWithRing;

public class PositionedWheelImpl implements PositionedWheel {

    private final int slotNumber;
    private final WheelWithRing wheelWithRing;
    private final PositionedWheel wheelToLeft;
    private final String alphabet;
    private final RotorPosition rotorPosition;

    boolean doubleStepNextStep = false;

    public PositionedWheelImpl(
            int slotNumber,
            String alphabet,
            RotorPosition rotorPosition,
            WheelWithRing wheelWithRing,
            PositionedWheel wheelToLeft
    ) {
        this.alphabet = alphabet;
        this.slotNumber = slotNumber;
        this.rotorPosition = rotorPosition;
        this.wheelWithRing = wheelWithRing;
        this.wheelToLeft = wheelToLeft;
    }

    @Override
    public void increment() {
        incrementWheelToLeftIfRequired();
        rotorPosition.increment();
        char currentCharacter = alphabet.charAt(rotorPosition.getRotorPosition());
        if(slotNumber == 1 && currentCharacter == wheelWithRing.getTriggerChar()) {
            doubleStepNextStep = true;
        }
    }

    //FIXME -- increment and double step should be single method?
    @Override
    public void doubleStep() {
        if(doubleStepNextStep) {
            incrementWheelToLeftIfRequired();
            rotorPosition.increment();
            doubleStepNextStep = false;
        }
    }

    private void incrementWheelToLeftIfRequired() {
        if (alphabet.charAt(rotorPosition.getRotorPosition()) == wheelWithRing.getTriggerChar()) {
            if (wheelToLeft != null) {
                wheelToLeft.increment();
            }
        }
    }

    @Override
    public SpatialIndex convertOutwardInput(SpatialIndex input) {
        int rawRotorPosition = rotorPosition.getRotorPosition();
        int alphabetLength = alphabet.length();
        WheelIndex inputIndex = input.withPosition(rawRotorPosition, alphabetLength);
        WheelIndex outputIndex = wheelWithRing.fromRight(inputIndex);
        SpatialIndex spatialIndex = outputIndex.withPosition(rawRotorPosition, alphabetLength);
        return spatialIndex;
    }

    @Override
    public SpatialIndex convertReturnInput(SpatialIndex input) {
        int rawRotorPosition = rotorPosition.getRotorPosition();
        int alphabetLength = alphabet.length();
        WheelIndex inputIndex = input.withPosition(rawRotorPosition, alphabetLength);
        WheelIndex outputIndex = wheelWithRing.fromLeft(inputIndex);
        SpatialIndex spatialIndex = outputIndex.withPosition(rawRotorPosition, alphabetLength);
        return spatialIndex;
    }

    @Override
    public RotorPosition getRotorPosition() {
        return rotorPosition;
    }

    @Override
    public Character getCharSetting() {
        return alphabet.charAt(rotorPosition.getRotorPosition());
    }
}
