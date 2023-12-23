package com.example.tibiaeventbusproject.loginAndRegisterLayer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class HashGeneratorTest {

    private static List<String> listOfEmails = new ArrayList<>();

    @BeforeAll
    static void setUp()
    {
        listOfEmails.add("ape123@wp.pl");
        listOfEmails.add("ape123@wp.pl");
        listOfEmails.add("example@gmail.com");
        listOfEmails.add("test@example.com");
        listOfEmails.add("user123@yahoo.com");
        listOfEmails.add("john.doe@hotmail.com");
    }

    @Test
    void getBcryptHashString() {

        listOfEmails.stream().forEach((email)-> {
            assertEquals(HashGenerator.getHashPasswordUsingMD5(email),HashGenerator.getHashPasswordUsingMD5(email));
        });
    }

    @Test
    void verifyBcryptHashString() {

        listOfEmails.stream().forEach((x)-> {
            assertTrue(HashGenerator.verifyHashPassword( HashGenerator.getHashPasswordUsingMD5(x), HashGenerator.getHashPasswordUsingMD5(x)));
        });
    }
}