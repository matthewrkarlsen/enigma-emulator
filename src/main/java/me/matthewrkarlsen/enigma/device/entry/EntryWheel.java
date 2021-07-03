package me.matthewrkarlsen.enigma.device.entry;

import me.matthewrkarlsen.enigma.utilities.CharRange;

import java.util.List;

public class EntryWheel {

    private final List<Character> setupChars;

    public EntryWheel() {
        setupChars = new CharRange('A', 'Z').toList();
    }

    public int fromRight(char input) {
        return setupChars.indexOf(input);
    }

    public char fromLeft(int input) {
        return setupChars.get(input);
    }
}
