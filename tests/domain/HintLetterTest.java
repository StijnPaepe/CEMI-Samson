package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HintLetterTest {
    @Test
    public void test_HintLetter_moet_HintLetter_maken_die_niet_geraden_is() {
        HintLetter letter = new HintLetter('a');

        assertFalse(letter.isGeraden());
    }

    @Test
    public void test_Raad_Moet_True_Teruggeven_En_Op_Geraden_Zetten_Als_Juiste_Letter() {
        HintLetter letter = new HintLetter('x');

        assertTrue(letter.raad('x'));
        assertTrue(letter.isGeraden());
    }

    @Test
    public void test_Raad_Moet_True_Teruggeven_En_Op_Geraden_Zetten_Als_Juiste_Letter_Maar_UpperCase_In_Plaats_Van_Lowercase() {
        HintLetter letter = new HintLetter('x');

        assertTrue(letter.raad('X'));
        assertTrue(letter.isGeraden());
    }

    @Test
    public void test_Raad_Moet_True_Teruggeven_En_Op_Geraden_Zetten_Als_Juiste_Letter_Maar_LowerCase_In_Plaats_Van_Uppercase() {
        HintLetter letter = new HintLetter('X');

        assertTrue(letter.raad('x'));
        assertTrue(letter.isGeraden());
    }

    @Test
    public void test_Raad_Moet_False_Teruggeven_Als_Verkeerde_Letter() {
        HintLetter letter = new HintLetter('x');

        assertFalse(letter.raad('y'));
        assertFalse(letter.isGeraden());
    }

    @Test
    public void test_Raad_Moet_False_Teruggeven_Maar_Op_Geraden_Laten_Staan_Als_Juiste_Letter_Maar_Reeds_Geraden() {
        HintLetter letter = new HintLetter('f');

        assertTrue(letter.raad('f'));
        assertTrue(letter.isGeraden());
        assertFalse(letter.raad('f'));
    }

    @Test
    public void test_ToChar_Moet_Letter_Tonen_Als_Geraden() {
        HintLetter letter = new HintLetter('x');
        assertTrue(letter.raad('x'));

        assertEquals('x', letter.toChar());
        ;
    }

    @Test
    public void test_ToChar_Moet_Streepje_Teruggeven_Als_Niet_Geraden() {
        HintLetter letter = new HintLetter('x');

        assertEquals('_', letter.toChar());
    }

    @Test
    public void test_TetLetter_Moet_Letter_Teruggeven_Als_Geraden() {
        HintLetter letter = new HintLetter('x');
        assertTrue(letter.raad('x'));

        assertEquals('x', letter.toChar());
    }

    @Test
    public void test_GetLetter_Moet_Letter_Teruggeven_Als_Niet_Geraden() {
        HintLetter letter = new HintLetter('x');

        assertEquals('x', letter.getLetter());
    }
}