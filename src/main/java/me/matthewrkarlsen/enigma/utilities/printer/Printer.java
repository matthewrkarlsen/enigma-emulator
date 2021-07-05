package me.matthewrkarlsen.enigma.utilities.printer;

public class Printer {

    private final boolean verbose;

    public Printer(boolean verbose) {
        this.verbose = verbose;
    }

    public void println(String string, PrinterLevel requiredLevel) {
        if (requiredLevel == PrinterLevel.VERBOSE && !verbose) {
            return;
        }
        System.out.println(string);
    }

    public void print(String string, PrinterLevel requiredLevel) {
        if (requiredLevel == PrinterLevel.VERBOSE && !verbose) {
            return;
        }
        System.out.print(string);
    }

}
