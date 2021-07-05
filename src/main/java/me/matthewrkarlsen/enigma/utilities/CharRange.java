package me.matthewrkarlsen.enigma.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CharRange implements Iterable<Character> {

    private final Character[] range;

    public CharRange(char firstCharInclusive, char lastCharInclusive) {
        List<Character> characterList = new ArrayList<>();
        if(lastCharInclusive < firstCharInclusive) {
            throw new IllegalStateException("First char must occur before last char");
        }
        char c = firstCharInclusive;
        while(c <= lastCharInclusive) {
            characterList.add(c);
            c++;
        }
        Character[] rangeTmp = new Character[characterList.size()];
        range = characterList.toArray(rangeTmp);
    }

    @Override
    public Iterator<Character> iterator() {
        return Arrays.asList(range).iterator();
    }

    public char[] toArray() {
        char[] retArray = new char[range.length];
        for(int i = 0; i < retArray.length; i++) {
            retArray[i] = range[i];
        }
        return retArray;
    }

    public List<Character> toList() {
        return Arrays.asList(range);
    }
}
