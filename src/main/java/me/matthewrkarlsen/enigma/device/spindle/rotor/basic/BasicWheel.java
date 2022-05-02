package me.matthewrkarlsen.enigma.device.spindle.rotor.basic;

import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelIndex;

public class BasicWheel implements Wheel {

    public String alphabet;
    public String wheelSymbolSequence;

    public BasicWheel(String alphabet, String wheelSymbolSequence) {
        this.alphabet = alphabet;
        this.wheelSymbolSequence = wheelSymbolSequence;
    }

    @Override
    public WheelIndex convertOutwardInput(WheelIndex input) {
        char c = wheelSymbolSequence.charAt(input.value());
        return WheelIndex.of(alphabet.indexOf(c));
    }

    @Override
    public WheelIndex convertReturnInput(WheelIndex input) {
        char c = alphabet.charAt(input.value());
        return WheelIndex.of(wheelSymbolSequence.indexOf(c));
    }
}
