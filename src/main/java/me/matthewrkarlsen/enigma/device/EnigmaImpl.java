package me.matthewrkarlsen.enigma.device;

import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.SpatialIndex;
import me.matthewrkarlsen.enigma.device.spindle.Spindle;
import me.matthewrkarlsen.enigma.device.entry.EntryWheel;
import me.matthewrkarlsen.enigma.utilities.printer.Printer;
import me.matthewrkarlsen.enigma.utilities.printer.PrinterLevel;
import me.matthewrkarlsen.enigma.device.reflector.Reflector;
import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.PositionedWheel;
import me.matthewrkarlsen.enigma.utilities.CharRange;

import java.util.List;

public class EnigmaImpl implements Enigma {

    private final Printer printer;
    private final Spindle spindle;
    private final Reflector reflector;
    private final EntryWheel entryWheel;

    public EnigmaImpl(Printer printer, Spindle spindle, Reflector reflector, EntryWheel entryWheel) {
        this.printer = printer;
        this.spindle = spindle;
        this.reflector = reflector;
        this.entryWheel = entryWheel;
    }

    @Override
    public String convert(String input) {
        List<Character> alphabet = new CharRange('A', 'Z').toList();
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = input.toCharArray();
        printer.print("Wheel positions: ", PrinterLevel.VERBOSE);
        for(PositionedWheel positionedPositionedWheel : spindle) {
            printer.print(String.valueOf(alphabet.get(positionedPositionedWheel.getPosition())), PrinterLevel.VERBOSE);
        }
        printer.println("", PrinterLevel.VERBOSE);
        for (char c : chars) {
            spindle.get(1).doubleStep();
            spindle.get(2).increment();
            SpatialIndex inputInt = new SpatialIndex(entryWheel.fromRight(c));
            printer.print(c + " -> " + inputInt + " | ", PrinterLevel.VERBOSE);
            for (int i = 2; i > -1; i--) {
                PositionedWheel wheel = spindle.get(i);
                printer.print(String.valueOf(inputInt), PrinterLevel.VERBOSE);
                inputInt = wheel.fromRight(inputInt);
                printer.print(" -> " + inputInt + " | ", PrinterLevel.VERBOSE);
            }
            printer.print(String.valueOf(inputInt), PrinterLevel.VERBOSE);
            inputInt = reflector.fromRight(inputInt);
            printer.print(" -> " + inputInt + " | ", PrinterLevel.VERBOSE);
            for (int i = 0; i < 3; i++) {
                PositionedWheel wheel = spindle.get(i);
                printer.print(String.valueOf(inputInt), PrinterLevel.VERBOSE);
                inputInt = wheel.fromLeft(inputInt);
                printer.print(" -> " + inputInt + " | ", PrinterLevel.VERBOSE);
            }
            int value = inputInt.value();
            char c1 = entryWheel.fromLeft(value);
            printer.print(inputInt + " -> " + c1, PrinterLevel.VERBOSE);
            printer.println("", PrinterLevel.VERBOSE);
            stringBuilder.append(c1);
            printer.print("Wheel positions: ", PrinterLevel.VERBOSE);
            for (PositionedWheel positionedPositionedWheel : spindle) {
                printer.print(String.valueOf(alphabet.get(positionedPositionedWheel.getPosition())), PrinterLevel.VERBOSE);
            }
            printer.println("", PrinterLevel.VERBOSE);
        }
        return stringBuilder.toString();
    }
}
