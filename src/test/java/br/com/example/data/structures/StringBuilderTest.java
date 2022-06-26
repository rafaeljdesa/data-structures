package br.com.example.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringBuilderTest {

    private StringBuilder stringBuilder;

    @Before
    public void setup() {
        stringBuilder = new StringBuilder();
    }

    @Test
    public void stringBuilderTest() {
        stringBuilder.append("Test1 ")
                     .append("Test2");
        assertEquals("Test1 Test2", stringBuilder.toString());
    }

}