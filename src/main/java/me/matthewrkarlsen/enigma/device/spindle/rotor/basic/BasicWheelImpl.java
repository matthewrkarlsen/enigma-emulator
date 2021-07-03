package me.matthewrkarlsen.enigma.device.spindle.rotor.basic;

import me.matthewrkarlsen.enigma.utilities.CharRange;
import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelIndex;

import java.util.ArrayList;
import java.util.List;

public class BasicWheelImpl implements BasicWheel {

    public List<Character> baseChars;
    public List<Character> customChars;

    public BasicWheelImpl(String letterRepresentation) {
        baseChars = new CharRange('A', 'Z').toList();
        char[] chars = letterRepresentation.toCharArray();
        customChars = new ArrayList<>();
        for(char c : chars) {
            customChars.add(c);
        }
    }

    @Override
    public WheelIndex fromRight(WheelIndex input) {
        Character c2 = customChars.get(input.value());
        return new WheelIndex(baseChars.indexOf(c2));
    }

    @Override
    public WheelIndex fromLeft(WheelIndex input) {
        Character c = baseChars.get(input.value());
        return new WheelIndex(customChars.indexOf(c));
    }
}
