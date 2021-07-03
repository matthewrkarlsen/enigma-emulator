package me.matthewrkarlsen.enigma.device.spindle.rotor.positioned;

public interface PositionedWheel {

    void increment();

    void doubleStep();

    SpatialIndex fromRight(SpatialIndex input);

    SpatialIndex fromLeft(SpatialIndex input);

    int getPosition();
}
