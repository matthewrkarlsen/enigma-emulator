# Enigma Emulator

This program provides basic emulation of a three-rotor Enigma cypher machine.

The current rotors used are rotors I, II and III of the Enigma I variant.

## Build

### Prerequisites

 * An open Java JDK 17 such as [Eclipse Temurin](https://adoptium.net/temurin/releases/)
 * Apache Maven 3.x

### Build (on Linux)

 * git clone the repository to a directory of your choice: 
   * `git clone https://github.com/matthewrkarlsen/enigma-emulator.git`
 * open a terminal inside the new `enigma-emulator` directory
 * run `mvn clean package`
 * check for the new jar `enigma-emulator-0.1.0-jar-with-dependencies.jar` in the target folder

## Emulator Usage 

The usage of the emulator is as follows:

### Console usage (on Linux)

`echo "HELLOWORLD" | java -jar enigma-emulator-0.1.0-jar-with-dependencies.jar` outputs `MFNCZBBFZM`

`echo "MFNCZBBFZM" | java -jar enigma-emulator-0.1.0-jar-with-dependencies.jar` outputs `HELLOWORLD`

### I/O from file (on Linux)

`echo "HELLOWORLD" > here.txt`

`cat ./here.txt | java -jar enigma-emulator-0.1.0-jar-with-dependencies.jar > ./there.txt`

`cat ./there.txt | java -jar enigma-emulator-0.1.0-jar-with-dependencies.jar > ./back_again.txt`

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
The third link above made the process much less error-prone and provided a way of verifying the
resulting emulator. The author would like to thank the creators of the above pages.

## Software Used

The software is constructed using Java 17 with the following additional libraries and build tools:

| Software    | Scope   | License                                                                                       |
|-------------|---------|-----------------------------------------------------------------------------------------------|
| SLF4J       | Main    | [MIT](https://github.com/qos-ch/slf4j/blob/master/LICENSE.txt)                                |
| Log4J 2.x   | Main    | [Apache 2.0](https://github.com/apache/logging-log4j2/blob/release-2.x/LICENSE.txt)           |
| JUnit 5.x   | Test    | [EPL 2.0](https://github.com/junit-team/junit5/blob/main/LICENSE.md)                          |
| Mockito 4.x | Test    | [MIT](https://github.com/mockito/mockito/blob/main/LICENSE)                                   |
| AssertJ 3.x | Test    | [Apache 2.0](https://github.com/assertj/assertj-core/blob/main/LICENSE.txt)                   |
| Maven       | Build   | [Apache 2.0](https://gitbox.apache.org/repos/asf?p=maven.git;a=blob_plain;f=LICENSE;hb=HEAD)  |