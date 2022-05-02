package me.matthewrkarlsen.enigma.utilities.printer;

public class Printer {

    //TODO: refactor to extract printer level check method that returns a Boolean
    //TODO: code tests for the extracted method
    //TODO: hold PrinterLevel, not 'boolean verbose'

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

    public void print(char c, PrinterLevel requiredLevel) {
        if (requiredLevel == PrinterLevel.VERBOSE && !verbose) {
            return;
        }
        System.out.print(c);
    }
}
