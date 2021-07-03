package me.matthewrkarlsen.enigma.setup;

import me.matthewrkarlsen.enigma.device.Enigma;
import me.matthewrkarlsen.enigma.device.EnigmaImpl;
import me.matthewrkarlsen.enigma.device.entry.EntryWheel;
import me.matthewrkarlsen.enigma.device.spindle.Spindle;
import me.matthewrkarlsen.enigma.utilities.printer.Printer;
import me.matthewrkarlsen.enigma.device.reflector.Reflector;
import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.PositionedWheel;
import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.PositionedWheelImpl;
import me.matthewrkarlsen.enigma.device.spindle.rotor.WheelInstance;
import me.matthewrkarlsen.enigma.device.spindle.rotor.positioned.RotorPosition;
import me.matthewrkarlsen.enigma.device.spindle.rotor.ringed.WheelWithRingImpl;

import java.util.List;

public class EnigmaFactory {

    public Enigma constructEnigma(EnigmaConfig cfg) {
        PositionedWheel w3 =
                new PositionedWheelImpl(
                        0,
                        new RotorPosition(cfg.getInt("enigma.machine.slot.left.rotor.position")),
                        new WheelWithRingImpl(
                                WheelInstance.withName(cfg.getString("enigma.machine.slot.left.rotor.name")),
                                cfg.getInt("enigma.machine.slot.left.ring.position"),
                                'V'
                        ),
                        null
                );
        PositionedWheelImpl w2 =
                new PositionedWheelImpl(
                        1,
                        new RotorPosition(cfg.getInt("enigma.machine.slot.center.rotor.position")),
                        new WheelWithRingImpl(
                                WheelInstance.withName(cfg.getString("enigma.machine.slot.center.rotor.name")),
                                cfg.getInt("enigma.machine.slot.center.ring.position"),
                                'E'
                        ),
                        w3
                );
        PositionedWheelImpl w1 =
                new PositionedWheelImpl(
                        2,
                        new RotorPosition(cfg.getInt("enigma.machine.slot.right.rotor.position")),
                        new WheelWithRingImpl(
                                WheelInstance.withName(cfg.getString("enigma.machine.slot.right.rotor.name")),
                                cfg.getInt("enigma.machine.slot.right.ring.position"),
                                'Q'
                        ),
                        w2
                );
        Enigma enigma = new EnigmaImpl(
                new Printer(cfg.getBoolean("enigma.printer.verbose")),
                new Spindle(
                        List.of(
                                w3,
                                w2,
                                w1
                        )
                ),
                Reflector.UKW_B,
                new EntryWheel()
        );
        return enigma;
    }
}
