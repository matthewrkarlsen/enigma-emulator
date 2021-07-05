# Enigma Emulator

The emulator is a very basic three-wheel implementation at present.
The wheels used are wheels I, II and III of the Enigma I variant.

## Emulator Usage 

The usage of the emulator is as follows:

### Console usage (on Linux)

`echo "HELLOWORLD" | java -jar enigma-emu-0.0.1.jar` outputs `MFNCZBBFZM`

`echo "MFNCZBBFZM" | java -jar enigma-emu-0.0.1.jar` outputs `HELLOWORLD`

### I/O from file (on Linux)

`echo "HELLOWORLD" > here.txt`

`cat ./here.txt | java -jar enigma-emu-0.0.1.jar > ./there.txt`

`cat ./there.txt | java -jar enigma-emu-0.0.1.jar > ./back_again.txt`

## Acknowledgements

The wiring for the wheels and reflectors of the Enigma was obtained from the
[Enigma Wiring](https://www.cryptomuseum.com/crypto/enigma/wiring.htm) page of the Crypto Museum.
Similarly, this page contains information on the 'notch' and 'turnover' details of each wheel.

This [Enigma details](http://users.telenet.be/d.rijmenants/en/enigmatech.htm#steppingmechanism) page
was critical in the replication of the original design, since it explains the stepping mechanism very
clearly, including the double step.

An existing [Enigma Simulator](https://piotte13.github.io/enigma-cipher/) page was very helpful
to verify that enciphered text was accurate to the original design.

It would have been impossible to construct the emulator without the first two links above.
The third link above made the process much less error prone and provided a way of verifying the
resulting emulator. The author would like to thank the creators of the above pages.