package me.matthewrkarlsen.enigma.integration;

import me.matthewrkarlsen.enigma.device.Enigma;
import me.matthewrkarlsen.enigma.setup.EnigmaConfig;
import me.matthewrkarlsen.enigma.setup.EnigmaFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestIT {

    @Test
    public void test() throws IOException {

        Properties properties = new Properties();
        properties.load(TestIT.class.getClassLoader().getResourceAsStream("enigma.properties"));
        EnigmaConfig enigmaConfig = new EnigmaConfig(properties);

        String valid = "FTZMGISXIPJWGDNJJCOQTYRIGDMXFIESRWZGTOIUIEKKDCSHTPYOEPVXNHVRWWESFRUXDGWOZDMNKIZW";
        String input = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

        Enigma enigma = new EnigmaFactory().constructEnigma(enigmaConfig);
        String output = enigma.convert(input);

        assertEquals(valid, output);
    }

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        properties.load(TestIT.class.getClassLoader().getResourceAsStream("enigma.properties"));
        properties.setProperty("enigma.machine.slot.left.rotor.position", String.valueOf(10));
        properties.setProperty("enigma.machine.slot.center.rotor.position", String.valueOf(3));
        properties.setProperty("enigma.machine.slot.right.rotor.position", String.valueOf(14));
        EnigmaConfig enigmaConfig = new EnigmaConfig(properties);

        String valid = "ULMHJCJJCWBYZNMXFLUGEBRVUXXXFVDCGGCQZURBVXBLHIDHESNJGXDTXHGBHTRNZSKSYEUIKBQRUOHU";
        String input = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

        Enigma enigma = new EnigmaFactory().constructEnigma(enigmaConfig);
        String output = enigma.convert(input);

        assertEquals(valid, output);
    }

    @Test
    public void test3() throws IOException {

        Properties properties = new Properties();
        properties.load(TestIT.class.getClassLoader().getResourceAsStream("enigma.properties"));
        EnigmaConfig enigmaConfig = new EnigmaConfig(properties);

        String input = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

        Enigma enigma = new EnigmaFactory().constructEnigma(enigmaConfig);
        String output = enigma.convert(input);
        Enigma enigma2 = new EnigmaFactory().constructEnigma(enigmaConfig);
        String output2 = enigma2.convert(output);

        assertEquals(input, output2);
    }

    @Test
    public void test4() throws IOException {
        Properties properties = new Properties();
        properties.load(TestIT.class.getClassLoader().getResourceAsStream("enigma.properties"));
        properties.setProperty("enigma.machine.slot.left.rotor.position", String.valueOf(10));
        properties.setProperty("enigma.machine.slot.center.rotor.position", String.valueOf(3));
        properties.setProperty("enigma.machine.slot.right.rotor.position", String.valueOf(14));
        EnigmaConfig enigmaConfig = new EnigmaConfig(properties);
        
        String input = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

        Enigma enigma = new EnigmaFactory().constructEnigma(enigmaConfig);
        String output = enigma.convert(input);
        Enigma enigma2 = new EnigmaFactory().constructEnigma(enigmaConfig);
        String output2 = enigma2.convert(output);

        assertEquals(input, output2);
    }
}