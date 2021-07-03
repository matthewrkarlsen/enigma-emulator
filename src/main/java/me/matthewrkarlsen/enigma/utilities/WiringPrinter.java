package me.matthewrkarlsen.enigma.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WiringPrinter {

    Map<Integer, Integer> forwardMap = new HashMap<>();
    Map<Integer, Integer> reverseMap = new HashMap<>();
    public static void main(String[] args) {
        String rep = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
        List<Character> characterList = new CharRange('A', 'Z').toList();
        List<Integer> indexes = new ArrayList<>();
        for(Character c : rep.toCharArray()) {
            indexes.add(characterList.indexOf(c));
        }
        System.out.println(indexes.toString());
    }
}
