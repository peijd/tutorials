package com.ripjava.java.core.primitiveconversions;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimitiveConversionsTest {

    private static final Logger LOG = LoggerFactory.getLogger(PrimitiveConversionsTest.class);

    @Test
    public void test_DataWithLessBits() {
        int myInt = 127;

        long myLong = myInt;
        assertEquals(127L, myLong);

        float myFloat = myLong;
        assertEquals(127.0f, myFloat, 0.00001f);

        double myDouble = myLong;
        assertEquals(127.0, myDouble,0.00001);
    }

    @Test
    public void test_DataWithMoreBits() {

        long myLong = 127L;
        double myDouble = 127.0;

        float myFloat = (float) myDouble;
        assertEquals(127.0f, myFloat, 0.00001f);

        int myInt = (int) myLong;
        assertEquals(127, myInt);

        byte myByte = (byte) myInt;
        assertEquals( ((byte)127), myByte);
    }

    @Test
    public void test_PrimitiveData(){
        int myInt = 127;

        Integer myIntegerReference = myInt;
        assertEquals(127, myIntegerReference);

    }

    @Test
    public void test_WrapperObjectData(){
        Integer myIntegerReference = Integer.parseInt("127");

        int myOtherInt = myIntegerReference;
        assertEquals(127, myOtherInt);

    }

    @Test
    public void test_ByteValue(){
        byte myLargeValueByte = (byte) 130;   //0b10000010
        LOG.debug("{}", myLargeValueByte); //0b10000010 -126
        assertEquals( -126, myLargeValueByte);

        int myLargeValueInt = myLargeValueByte;
        LOG.debug("{}", myLargeValueInt); //0b11111111 11111111 11111111 10000010 -126
        assertEquals( -126, myLargeValueInt);

        char myLargeValueChar = (char) myLargeValueByte;
        LOG.debug("{}", myLargeValueChar);//0b11111111 10000010 unsigned 0xFF82
        assertEquals(0xFF82, myLargeValueChar);

        myLargeValueInt = myLargeValueChar;
        LOG.debug("{}", myLargeValueInt); //0b11111111 10000010  65410
        assertEquals(65410, myLargeValueInt);

        byte myOtherByte = (byte) myLargeValueInt;
        LOG.debug("{}", myOtherByte); //0b10000010 -126
        assertEquals( -126, myOtherByte);


        char myLargeValueChar2 = 130; // 130不是byte了
        LOG.debug("{}", myLargeValueChar2);//0b00000000 10000010 unsigned 0x0082
        assertEquals(0x0082, myLargeValueChar2);

        int myLargeValueInt2 = myLargeValueChar2;
        LOG.debug("{}", myLargeValueInt2); //0b00000000 10000010  130
        assertEquals(130, myLargeValueInt2);

        byte myOtherByte2 = (byte) myLargeValueInt2;
        LOG.debug("{}", myOtherByte2); //0b10000010 -126
        assertEquals( -126, myOtherByte2);
    }

    @Test
    public void test_String(){
        String myString = "127";

        byte  myNewByte   = Byte.parseByte(myString);
        assertEquals( ((byte)127), myNewByte);

        short myNewShort  = Short.parseShort(myString);
        assertEquals( ((short)127), myNewShort);

        int   myNewInt    = Integer.parseInt(myString);
        assertEquals( 127, myNewInt);

        long  myNewLong   = Long.parseLong(myString);
        assertEquals( 127L, myNewLong);

        float  myNewFloat  = Float.parseFloat(myString);
        assertEquals( 127.0f, myNewFloat, 0.00001f);

        double myNewDouble = Double.parseDouble(myString);
        assertEquals( 127.0, myNewDouble, 0.00001f);

        boolean myNewBoolean = Boolean.parseBoolean(myString);
        assertEquals( false, myNewBoolean);

        char myNewChar = myString.charAt(0);
        assertEquals( 49, myNewChar);
    }
}
