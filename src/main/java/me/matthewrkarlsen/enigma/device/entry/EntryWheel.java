package me.matthewrkarlsen.enigma.device.entry;

public class EntryWheel {

    private final String alphabet;

    public EntryWheel(String alphabet) {
        this.alphabet = alphabet;
    }

    public int convertCharacterToIndex(char input) {
        return alphabet.indexOf(input);
    }

    public char convertIndexToCharacter(int input) {
        return alphabet.charAt(input);
    }
}
