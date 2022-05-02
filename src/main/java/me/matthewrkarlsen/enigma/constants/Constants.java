package me.matthewrkarlsen.enigma.constants;

import me.matthewrkarlsen.enigma.device.reflector.Reflector;

public class Constants {

    public static final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static Reflector REFLECTOR_UKW_A =
            new Reflector("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "EJMZALYXVBWFCRQUONTSPIKHGD");

    public static Reflector REFLECTOR_UKW_B =
            new Reflector("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "YRUHQSLDPXNGOKMIEBFZCWVJAT");
}
