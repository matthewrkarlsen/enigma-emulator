package me.matthewrkarlsen.enigma.device.entry;

import org.junit.jupiter.api.Test;

import static me.matthewrkarlsen.enigma.constants.Constants.ENGLISH_ALPHABET;
import static org.assertj.core.api.Assertions.assertThat;

class EntryWheelTest {

    @Test
    void givenEnglishAlphabetEntryWheel_whenConvertCharacterAToIndex_thenReturnsIndex0() {
        assertThat(new EntryWheel(ENGLISH_ALPHABET).convertCharacterToIndex('A')).isEqualTo(0);
    }

    @Test
    void givenEnglishAlphabetEntryWheel_whenConvertCharacterKToIndex_thenReturnsIndex10() {
        assertThat(new EntryWheel(ENGLISH_ALPHABET).convertCharacterToIndex('K')).isEqualTo(10);
    }

    @Test
    void givenEnglishAlphabetEntryWheel_whenConvertCharacterUToIndex_thenReturnsIndex20() {
        assertThat(new EntryWheel(ENGLISH_ALPHABET).convertCharacterToIndex('U')).isEqualTo(20);
    }

    @Test
    void givenEnglishAlphabetEntryWheel_whenConvertCharacterZToIndex_thenReturnsIndex25() {
        assertThat(new EntryWheel(ENGLISH_ALPHABET).convertCharacterToIndex('Z')).isEqualTo(25);
    }

    @Test
    void givenEnglishAlphabetEntryWheel_whenConvertIndex0ToCharacter_thenReturnsCharacterA() {
        assertThat(new EntryWheel(ENGLISH_ALPHABET).convertIndexToCharacter(0)).isEqualTo('A');
    }

    @Test
    void givenEnglishAlphabetEntryWheel_whenConvertIndex10ToCharacter_thenReturnsCharacterK() {
        assertThat(new EntryWheel(ENGLISH_ALPHABET).convertIndexToCharacter(10)).isEqualTo('K');
    }

    @Test
    void givenEnglishAlphabetEntryWheel_whenConvertIndex20ToCharacter_thenReturnsCharacterU() {
        assertThat(new EntryWheel(ENGLISH_ALPHABET).convertIndexToCharacter(20)).isEqualTo('U');
    }

    @Test
    void givenEnglishAlphabetEntryWheel_whenConvertIndex25ToCharacter_thenReturnsCharacterZ() {
        assertThat(new EntryWheel(ENGLISH_ALPHABET).convertIndexToCharacter(25)).isEqualTo('Z');
    }
}