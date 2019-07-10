package com.ripjava.java.core.asciiart;

import org.junit.jupiter.api.Test;

import java.awt.*;

public class AsciiArtTest {
    @Test
    public void test_PrintAsciiArt() {
        AsciiArt asciiArt = new AsciiArt();
        String text = "RipJava";
        AsciiArt.Settings settings = asciiArt.new Settings(new Font("consolas", Font.PLAIN, 24), text.length() * 30, 30); // 30 pixel width per character

        asciiArt.drawString(text, "*", settings);
    }

}
