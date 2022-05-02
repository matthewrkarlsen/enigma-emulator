package me.matthewrkarlsen.enigma;

import me.matthewrkarlsen.enigma.device.Enigma;
import me.matthewrkarlsen.enigma.device.spindle.rotor.basic.RotorName;
import me.matthewrkarlsen.enigma.device.string.StringFactory;
import me.matthewrkarlsen.enigma.setup.EnigmaConfig;
import me.matthewrkarlsen.enigma.setup.EnigmaFactory;
import me.matthewrkarlsen.enigma.utilities.printer.Printer;
import me.matthewrkarlsen.enigma.utilities.printer.PrinterLevel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {

        EnigmaConfig enigmaConfig = assembleConfig(args);

        Printer printer = new Printer(isVerbose(args));
        printer.println(enigmaConfig.getString("enigma.splash.text"), PrinterLevel.VERBOSE);

        String stringIn = readInMessageOrUseDefault("HELLOWORLD");
        stringIn = removeUnhandledChars(stringIn);
        printer.println(stringIn, PrinterLevel.VERBOSE);
        printer.print("", PrinterLevel.VERBOSE);

        Enigma enigma = new EnigmaFactory().constructEnigma(enigmaConfig);
        String output = enigma.convert(stringIn);
        printer.println(output, PrinterLevel.NORMAL);
    }

    private static String readInMessageOrUseDefault(String defaultMessage) throws IOException {
        String stringIn = defaultMessage;
        if(System.in.available() > 0) {
            byte[] bytes = System.in.readAllBytes();
            stringIn = new String(bytes);
        }
        return stringIn;
    }

    private static String removeUnhandledChars(String stringIn) {
        String uppercaseStringIn = stringIn.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        String uppercaseAlphabet = new StringFactory().assembleString('A', 'Z');
        char[] uppercaseMessageCharacters = uppercaseStringIn.toCharArray();
        for(char c : uppercaseMessageCharacters) {
            if(uppercaseAlphabet.lastIndexOf(c) > -1) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private static EnigmaConfig assembleConfig(String[] args) throws IOException {
        boolean verbose = isVerbose(args);
        List<RotorName> rotorNames = getRotorNames(args);

        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("enigma.properties"));

        if(rotorNames.size() == 3) {
            properties.setProperty("enigma.machine.slot.left.rotor.name", rotorNames.get(0).toString());
            properties.setProperty("enigma.machine.slot.center.rotor.name", rotorNames.get(1).toString());
            properties.setProperty("enigma.machine.slot.right.rotor.name", rotorNames.get(2).toString());
        }

        if(verbose) {
            properties.setProperty("enigma.printer.verbose", String.valueOf(true));
        }

        return new EnigmaConfig(properties);
    }

    private static List<RotorName> getRotorNames(String[] args) {
        List<RotorName> rotorNames = new ArrayList<>();
        List<String> argsFiltered = Arrays.stream(args)
                .filter(arg -> arg.startsWith("--rotors="))
                .toList();
        if(argsFiltered.size() > 1) {
            throw new IllegalStateException("Only one rotor argument permitted");
        }
        if(argsFiltered.size() == 1) {
            String[] split = argsFiltered.get(0).replace("--rotors=", "").split(",");
            for(String s : split) {
                rotorNames.add(new RotorName(s));
            }
        }
        return rotorNames;
    }

    private static boolean isVerbose(String[] args) {
        return Arrays.asList(args).contains("--verbose");
    }
}
