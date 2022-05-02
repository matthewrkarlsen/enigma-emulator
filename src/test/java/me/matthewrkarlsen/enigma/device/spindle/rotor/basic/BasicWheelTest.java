package me.matthewrkarlsen.enigma.device.spindle.rotor.basic;

import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelIndex;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasicWheelTest {

    @Test
    void givenBasicWheel_whenConvertOutwardInputIndex3_thenReturnIndex3() {
        BasicWheel basicWheel = new BasicWheel("ABCDE", "CEADB");
        assertThat(basicWheel.convertOutwardInput(WheelIndex.of(3))).isEqualTo(WheelIndex.of(3));
    }

    @Test
    void givenBasicWheel_whenConvertOutwardInputIndex1_thenReturnIndex4() {
        BasicWheel basicWheel = new BasicWheel("ABCDE", "CEADB");
        assertThat(basicWheel.convertOutwardInput(WheelIndex.of(1))).isEqualTo(WheelIndex.of(4));
    }

    @Test
    void givenBasicWheel_whenConvertReturnInputIndex3_thenReturnIndex3() {
        BasicWheel basicWheel = new BasicWheel("ABCDE", "CEADB");
        assertThat(basicWheel.convertReturnInput(WheelIndex.of(3))).isEqualTo(WheelIndex.of(3));
    }

    @Test
    void givenBasicWheel_whenConvertReturnInputIndex4_thenReturnIndex1() {
        BasicWheel basicWheel = new BasicWheel("ABCDE", "CEADB");
        assertThat(basicWheel.convertReturnInput(WheelIndex.of(4))).isEqualTo(WheelIndex.of(1));
    }
}