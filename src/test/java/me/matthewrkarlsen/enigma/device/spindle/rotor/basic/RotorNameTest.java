package me.matthewrkarlsen.enigma.device.spindle.rotor.basic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RotorNameTest {

    @Test
    public void givenRotorName_whenToString_thenRawNameStringAsExpected() {
        assertThat(new RotorName("TheRotorNameIsHere").toString()).isEqualTo("TheRotorNameIsHere");
    }
}