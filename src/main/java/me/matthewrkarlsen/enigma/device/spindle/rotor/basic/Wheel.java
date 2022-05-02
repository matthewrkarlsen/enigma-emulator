package me.matthewrkarlsen.enigma.device.spindle.rotor.basic;

import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelIndex;

public interface Wheel {

    WheelIndex convertOutwardInput(WheelIndex input);

    WheelIndex convertReturnInput(WheelIndex input);
}
