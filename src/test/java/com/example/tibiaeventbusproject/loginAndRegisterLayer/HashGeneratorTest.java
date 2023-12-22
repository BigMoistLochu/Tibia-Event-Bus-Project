package com.example.tibiaeventbusproject.loginAndRegisterLayer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class HashGeneratorTest {

    private static String hashedEmailExample;

    @BeforeAll
    static void setUp()
    {
        //generujemy hash na podstawie emaila
        hashedEmailExample = HashGenerator.getBcryptHashString("ape123@wp.pl");
    }

    @Test
    void getBcryptHashString() {

        String hasedEmail = HashGenerator.getBcryptHashString("ape123@wp.pl");
        String hasedEmail2 = HashGenerator.getBcryptHashString("ape123@wp.pl");
        //te hashe zawsze beda inne lol
        assertEquals(hasedEmail2,hasedEmail);
    }

    @Test
    void verifyBcryptHashString() {

        //String email,String bcryptHashString

    }
}