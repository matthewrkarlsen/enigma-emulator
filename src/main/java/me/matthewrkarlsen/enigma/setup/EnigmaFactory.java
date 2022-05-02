package me.matthewrkarlsen.enigma.setup;

import me.matthewrkarlsen.enigma.constants.Constants;
import me.matthewrkarlsen.enigma.device.Enigma;
import me.matthewrkarlsen.enigma.device.EnigmaImpl;
import me.matthewrkarlsen.enigma.device.entry.EntryWheel;
import me.matthewrkarlsen.enigma.device.spindle.Spindle;
import me.matthewrkarlsen.enigma.device.spindle.rotor.NamedWheel;
import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.PositionedWheel;
import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.PositionedWheelImpl;
import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.RotorPosition;
import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelWithRingImpl;
import me.matthewrkarlsen.enigma.device.string.StringFactory;

import java.util.List;

public class EnigmaFactory {

    public Enigma constructEnigma(EnigmaConfig cfg) {
        String englishUppercaseAlphabet = new StringFactory().assembleString('A', 'Z');
        PositionedWheel w3 =
                new PositionedWheelImpl(
                        0,
                        englishUppercaseAlphabet,
                        new RotorPosition(cfg.getInt("enigma.machine.slot.left.rotor.position"), englishUppercaseAlphabet.length()),
                        new WheelWithRingImpl(
                                englishUppercaseAlphabet,
                                NamedWheel.withName(cfg.getString("enigma.machine.slot.left.rotor.name")),
                                cfg.getInt("enigma.machine.slot.left.ring.position"),
                                'V'
                        ),
                        null
                );
        PositionedWheelImpl w2 =
                new PositionedWheelImpl(
                        1,
                        englishUppercaseAlphabet,
                        new RotorPosition(cfg.getInt("enigma.machine.slot.center.rotor.position"), englishUppercaseAlphabet.length()),
                        new WheelWithRingImpl(
                                englishUppercaseAlphabet,
                                NamedWheel.withName(cfg.getString("enigma.machine.slot.center.rotor.name")),
                                cfg.getInt("enigma.machine.slot.center.ring.position"),
                                'E'
                        ),
                        w3
                );
        PositionedWheelImpl w1 =
                new PositionedWheelImpl(
                        2,
                        englishUppercaseAlphabet,
                        new RotorPosition(cfg.getInt("enigma.machine.slot.right.rotor.position"), englishUppercaseAlphabet.length()),
                        new WheelWithRingImpl(
                                englishUppercaseAlphabet,
                                NamedWheel.withName(cfg.getString("enigma.machine.slot.right.rotor.name")),
                                cfg.getInt("enigma.machine.slot.right.ring.position"),
                                'Q'
                        ),
                        w2
                );
        Enigma enigma = new EnigmaImpl(
                new Spindle(
                        List.of(
                                w3,
                                w2,
                                w1
                        )
                ),
                Constants.REFLECTOR_UKW_B,
                new EntryWheel(
                        new StringFactory().assembleString('A', 'Z')
                )
        );
        return enigma;
    }
}
