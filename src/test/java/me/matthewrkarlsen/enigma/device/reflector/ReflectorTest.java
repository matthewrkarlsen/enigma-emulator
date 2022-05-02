package me.matthewrkarlsen.enigma.device.reflector;

import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.SpatialIndex;
import org.junit.jupiter.api.Test;

import static me.matthewrkarlsen.enigma.constants.Constants.REFLECTOR_UKW_B;
import static org.assertj.core.api.Assertions.assertThat;

class ReflectorTest {

    @Test
    void givenSpatialIndexInput0_whenReflect_thenCorrectSpatialIndexOutput24() {
        assertThat(REFLECTOR_UKW_B.reflect(SpatialIndex.of(0))).isEqualTo(SpatialIndex.of(24));
    }

    @Test
    void givenSpatialIndexInput25_whenReflect_thenCorrectSpatialIndexOutput19() {
        assertThat(REFLECTOR_UKW_B.reflect(SpatialIndex.of(25))).isEqualTo(SpatialIndex.of(19));
    }

    @Test
    void givenSpatialIndexInput13_whenReflect_thenCorrectSpatialIndexOutput10() {
        assertThat(REFLECTOR_UKW_B.reflect(SpatialIndex.of(13))).isEqualTo(SpatialIndex.of(10));
    }
}