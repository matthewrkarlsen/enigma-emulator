package me.matthewrkarlsen.enigma.device.spindle.rotor;

import me.matthewrkarlsen.enigma.constants.Constants;
import me.matthewrkarlsen.enigma.device.spindle.rotor.basic.Wheel;
import me.matthewrkarlsen.enigma.device.spindle.rotor.basic.BasicWheel;
import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelIndex;

import java.util.Arrays;

import static java.lang.String.format;

public enum NamedWheel implements Wheel {
    ENIGMA_1_I("ENIGMA_1_I", new BasicWheel(Constants.ENGLISH_ALPHABET, "EKMFLGDQVZNTOWYHXUSPAIBRCJ")),
    ENIGMA_1_II("ENIGMA_1_II", new BasicWheel(Constants.ENGLISH_ALPHABET, "AJDKSIRUXBLHWTMCQGZNPYFVOE")),
    ENIGMA_1_III("ENIGMA_1_III", new BasicWheel(Constants.ENGLISH_ALPHABET, "BDFHJLCPRTXVZNYEIWGAKMUSQO"));

    private final String name;
    private final Wheel basicWheel;

    NamedWheel(String name, Wheel basicWheel) {
        this.name = name;
        this.basicWheel = basicWheel;
    }

    public static NamedWheel withName(String name) {
        return Arrays.stream(NamedWheel.values())
                .filter(namedWheel -> namedWheel.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        format("Wheel name %s not valid", name)
                ));
    }

    @Override
    public WheelIndex convertOutwardInput(WheelIndex input) {
        return basicWheel.convertOutwardInput(input);
    }

    @Override
    public WheelIndex convertReturnInput(WheelIndex input) {
        return basicWheel.convertReturnInput(input);
    }
}
