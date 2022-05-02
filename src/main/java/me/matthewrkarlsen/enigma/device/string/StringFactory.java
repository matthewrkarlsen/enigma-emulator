package me.matthewrkarlsen.enigma.device.string;

public class StringFactory {

    public String assembleString(char firstCharInclusive, char lastCharInclusive) {
        if(lastCharInclusive < firstCharInclusive) {
            throw new IllegalArgumentException("First char must occur before last char");
        }
        int arrayLength = lastCharInclusive - firstCharInclusive + 1;
        char[] range = new char[arrayLength];
        char c = firstCharInclusive;
        for(int i = 0; i < range.length; i++) {
            range[i] = c;
            c++;
        }
        return new String(range);
    }
}
