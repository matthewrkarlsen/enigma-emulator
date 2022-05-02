package me.matthewrkarlsen.enigma.device.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringFactoryTest {

    @Test
    void givenStringFactory_whenAssembleStringFromAToZ_thenEnglishAlphabetStringProduced() {
        StringFactory stringFactory = new StringFactory();
        String assembledString = stringFactory.assembleString('A', 'Z');
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", assembledString);
    }

    @Test
    void givenFactory_whenAssembleStringLowercaseAlphaToOmega_thenGreekAlphabetStringProduced() {
        StringFactory stringFactory = new StringFactory();
        String assembledString = stringFactory.assembleString('α', 'ω');
        assertEquals("αβγδεζηθικλμνξοπρςστυφχψω", assembledString); //NB: ς and σ both sigma...
    }
}