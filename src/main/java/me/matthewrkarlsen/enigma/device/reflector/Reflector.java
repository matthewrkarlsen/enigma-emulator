package me.matthewrkarlsen.enigma.device.reflector;

import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.SpatialIndex;

public class Reflector {

    public String inputChars;
    public String outputChars;

    public Reflector(String inputChars, String outputChars) {
        this.inputChars = inputChars;
        this.outputChars = outputChars;
    }

    public SpatialIndex reflect(SpatialIndex input) {
        char inputChar = inputChars.charAt(input.value());
        int outputIndex = outputChars.indexOf(inputChar);
        return new SpatialIndex(outputIndex);
    }
}
