package me.matthewrkarlsen.enigma.device.spindle.rotor.positioned;

public interface PositionedWheel {

    void increment();

    void doubleStep();

    SpatialIndex convertOutwardInput(SpatialIndex input);

    SpatialIndex convertReturnInput(SpatialIndex input);

    RotorPosition getRotorPosition();

    Character getCharSetting();
}
