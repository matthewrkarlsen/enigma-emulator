package me.matthewrkarlsen.enigma.device.spindle.rotor.basic;

import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelIndex;

public interface BasicWheel {

    WheelIndex fromRight(WheelIndex input);

    WheelIndex fromLeft(WheelIndex input);
}
