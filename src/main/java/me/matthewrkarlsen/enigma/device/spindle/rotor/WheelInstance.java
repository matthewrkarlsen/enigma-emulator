package me.matthewrkarlsen.enigma.device.spindle.rotor;

import me.matthewrkarlsen.enigma.device.spindle.rotor.basic.BasicWheel;
import me.matthewrkarlsen.enigma.device.spindle.rotor.basic.BasicWheelImpl;

public enum WheelInstance {
    ENIGMA_1_I("ENIGMA_1_I", new BasicWheelImpl("EKMFLGDQVZNTOWYHXUSPAIBRCJ")),
    ENIGMA_1_II("ENIGMA_1_II", new BasicWheelImpl("AJDKSIRUXBLHWTMCQGZNPYFVOE")),
    ENIGMA_1_III("ENIGMA_1_III", new BasicWheelImpl("BDFHJLCPRTXVZNYEIWGAKMUSQO"));

    private final String name;
    private final BasicWheel basicWheel;

    WheelInstance(String name, BasicWheel basicWheel) {
        this.name = name;
        this.basicWheel = basicWheel;
    }

    BasicWheel getWheel() {
        return this.basicWheel;
    }

    public static BasicWheel withName(String name) {
        return WheelInstance.valueOf(name.toUpperCase()).getWheel();
    }
}
