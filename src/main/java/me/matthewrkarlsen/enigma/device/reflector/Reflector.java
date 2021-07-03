package me.matthewrkarlsen.enigma.device.reflector;

import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.SpatialIndex;
import me.matthewrkarlsen.enigma.utilities.CharRange;

import java.util.ArrayList;
import java.util.List;

public class Reflector {

    public static Reflector UKW_A = new Reflector("EJMZALYXVBWFCRQUONTSPIKHGD");
    public static Reflector UKW_B = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");

    public List<Character> baseChars;
    public List<Character> customChars;

    public Reflector(String letterRepresentation) {
        baseChars = new CharRange('A', 'Z').toList();
        char[] chars = letterRepresentation.toCharArray();
        customChars = new ArrayList<>();
        for(char c : chars) {
            customChars.add(c);
        }
    }

    public SpatialIndex fromRight(SpatialIndex input) {
        return new SpatialIndex(customChars.indexOf(baseChars.get(input.value())));
    }

    public SpatialIndex fromLeft(SpatialIndex input) {
        return new SpatialIndex(baseChars.indexOf(customChars.get(input.value())));
    }
}
