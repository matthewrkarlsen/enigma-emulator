package me.matthewrkarlsen.enigma.device;

import me.matthewrkarlsen.enigma.device.entry.EntryWheel;
import me.matthewrkarlsen.enigma.device.reflector.Reflector;
import me.matthewrkarlsen.enigma.device.spindle.Spindle;
import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.PositionedWheel;
import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.SpatialIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnigmaImpl implements Enigma {

    private static final Logger logger = LoggerFactory.getLogger(EnigmaImpl.class);

    private final Spindle spindle;
    private final Reflector reflector;
    private final EntryWheel entryWheel;

    public EnigmaImpl(
            Spindle spindle,
            Reflector reflector,
            EntryWheel entryWheel
    ) {
        this.spindle = spindle;
        this.reflector = reflector;
        this.entryWheel = entryWheel;
    }

    @Override
    public String convert(String input) {
        StringBuilder outputStringBuilder = new StringBuilder();
        char[] chars = input.toCharArray();
        StringBuilder wheelPositionsStringBuilder = new StringBuilder();
        wheelPositionsStringBuilder.append("Wheel positions: ");
        for(PositionedWheel positionedPositionedWheel : spindle) {
            wheelPositionsStringBuilder.append(positionedPositionedWheel.getCharSetting());
        }
        logger.debug(wheelPositionsStringBuilder.toString());
        for (char c : chars) {
            StringBuilder oneIOStringBuilder = new StringBuilder();
            spindle.get(1).doubleStep();
            spindle.get(2).increment();
            SpatialIndex inputInt = new SpatialIndex(entryWheel.convertCharacterToIndex(c));
            oneIOStringBuilder.append(c).append(" -> ").append(inputInt).append(" | ");
            for (int i = 2; i > -1; i--) {
                PositionedWheel wheel = spindle.get(i);
                oneIOStringBuilder.append(inputInt);
                inputInt = wheel.convertOutwardInput(inputInt);
                oneIOStringBuilder.append(" -> ").append(inputInt).append(" | ");
            }
            oneIOStringBuilder.append(inputInt);
            inputInt = reflector.reflect(inputInt);
            oneIOStringBuilder.append(" -> ").append(inputInt).append(" | ");
            for (int i = 0; i < 3; i++) {
                PositionedWheel wheel = spindle.get(i);
                oneIOStringBuilder.append(inputInt);
                inputInt = wheel.convertReturnInput(inputInt);
                oneIOStringBuilder.append(" -> ").append(inputInt).append(" | ");
            }
            int value = inputInt.value();
            char c1 = entryWheel.convertIndexToCharacter(value);
            oneIOStringBuilder.append(inputInt).append(" -> ").append(c1);
            logger.debug(oneIOStringBuilder.toString());
            outputStringBuilder.append(c1);
            StringBuilder wheelPositionsStringBuilder2 = new StringBuilder();
            wheelPositionsStringBuilder2.append("Wheel positions: ");
            for (PositionedWheel positionedPositionedWheel : spindle) {
                wheelPositionsStringBuilder2.append(positionedPositionedWheel.getCharSetting());
            }
            logger.debug(wheelPositionsStringBuilder2.toString());
        }
        return outputStringBuilder.toString();
    }
}
