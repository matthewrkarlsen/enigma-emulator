package me.matthewrkarlsen.enigma.device.spindle.rotor.positioned;

import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelWithRing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class PositionedWheelImplTest {

    @Test
    void getRotorPosition() {
        RotorPosition rotorPosition = mock(RotorPosition.class);
        PositionedWheel positionedWheel =
                new PositionedWheelImpl(
                        0,
                        "ABC",
                        rotorPosition,
                        mock(WheelWithRing.class),
                        null
                );
        assertEquals(rotorPosition, positionedWheel.getRotorPosition());
    }
}