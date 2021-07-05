package me.matthewrkarlsen.enigma;

import me.matthewrkarlsen.enigma.device.Enigma;
import me.matthewrkarlsen.enigma.device.spindle.rotor.basic.RotorName;
import me.matthewrkarlsen.enigma.utilities.printer.Printer;
import me.matthewrkarlsen.enigma.utilities.printer.PrinterLevel;
import me.matthewrkarlsen.enigma.setup.EnigmaConfig;
import me.matthewrkarlsen.enigma.setup.EnigmaFactory;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        EnigmaConfig enigmaConfig = assembleConfig(args);

        Printer printer = new Printer(isVerbose(args));
        printer.println(enigmaConfig.getString("enigma.splash.text"), PrinterLevel.VERBOSE);

        String stringIn = "HELLOWORLD";
        if(System.in.available() > 0) {
            byte[] bytes = System.in.readAllBytes();
            stringIn = new String(bytes);
        }
        stringIn = removeUnhandledChars(stringIn);
        printer.println(stringIn, PrinterLevel.VERBOSE);
        printer.print("", PrinterLevel.VERBOSE);

        Enigma enigma = new EnigmaFactory().constructEnigma(enigmaConfig);
        String output = enigma.convert(stringIn);
        printer.println(output, PrinterLevel.NORMAL);
        printer.print("", PrinterLevel.VERBOSE);
    }

    private static String removeUnhandledChars(String stringIn) {
        stringIn = stringIn.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        char[] alphabetUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for(char c : stringIn.toCharArray()) {
            for(char c2 : alphabetUppercase) {
                if(c == c2) {
                    stringBuilder.append(c);
                    break;
                }
            }
        }
        stringIn = stringBuilder.toString();
        return stringIn;
    }

    private static EnigmaConfig assembleConfig(String[] args) throws IOException {
        boolean verbose = isVerbose(args);
        List<RotorName> rotorNames = getRotorNames(args);

        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("enigma.properties"));

        if(rotorNames.size() == 3) {
            properties.setProperty("enigma.machine.slot.left.rotor.name", rotorNames.get(0).value());
            properties.setProperty("enigma.machine.slot.center.rotor.name", rotorNames.get(1).value());
            properties.setProperty("enigma.machine.slot.right.rotor.name", rotorNames.get(2).value());
        }

        if(verbose) {
            properties.setProperty("enigma.printer.verbose", String.valueOf(true));
        }

        return new EnigmaConfig(properties);
    }

    private static List<RotorName> getRotorNames(String[] args) {
        List<RotorName> rotorNames = new ArrayList<>();
        List<String> argsFiltered = Arrays.stream(args).filter(arg -> arg.startsWith("--rotors="))
                .collect(Collectors.toList());
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
