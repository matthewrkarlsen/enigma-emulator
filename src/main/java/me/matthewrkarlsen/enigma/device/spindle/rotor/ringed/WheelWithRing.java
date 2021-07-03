package me.matthewrkarlsen.enigma.device.spindle.rotor.ringed;

public interface WheelWithRing {

    WheelIndex fromRight(WheelIndex input);

    WheelIndex fromLeft(WheelIndex input);

    Character getTriggerChar();
}
