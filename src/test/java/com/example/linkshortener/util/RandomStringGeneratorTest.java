package com.example.linkshortener.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomStringGeneratorTest {
    StringGenerator stringGenerator = new RandomStringGenerator();

    @Test
    void mustReturnEmptyStringIfLengthIsZero() {
        //given
        int length = 0;

        //when
        String generatedString = stringGenerator.generate(length);

        //then
        assertTrue(generatedString.isEmpty());
    }

    @Test
    void stringLengthMustBeEqualToLengthArgument() {
        //given
        int length = 10;

        //when
        String generatedString = stringGenerator.generate(length);

        //then
        assertEquals(length, generatedString.length());
    }

    @Test
    void stringMustBeRandom() {
        //given
        int length = 20;

        //when
        String one = stringGenerator.generate(length);
        String two = stringGenerator.generate(length);

        //then
        assertNotEquals(one,two);
    }
}