package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PuntTest {

    private int xCoordinaat;
    private int yCoordinaat;
    private int xCoordinaat2;
    private int yCoordinaat2;
    private Punt punt;
    private Punt punt2;
    private Punt puntXGelijk;


    @Before
    public void setUp() throws Exception {
        xCoordinaat = 5;
        yCoordinaat = 10;
        xCoordinaat2 = 9;
        yCoordinaat2 = 18;
        punt = new Punt(xCoordinaat, yCoordinaat);
        punt2 = new Punt(xCoordinaat2, yCoordinaat2);
        puntXGelijk = new Punt(xCoordinaat, yCoordinaat2);
    }

    @Test
    public void Punt_moet_een_punt_maken_met_de_gegeven_coordinaten() {
        punt = new Punt(xCoordinaat, yCoordinaat);
        assertEquals(xCoordinaat, punt.getX());
        assertEquals(yCoordinaat, punt.getY());
    }

    public void equals_moet_true_teruggeven_als_x_en_y_coordinaat_gelijk_zijn(){
        Punt puntAnder = new Punt(xCoordinaat, yCoordinaat);
        assertTrue(punt.equals(puntAnder));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        assertFalse(punt.equals(null));
    }

    @Test
    public void compareTo_moet1Teruggeven_als_x_van_punt1_kleiner_is (){
        assertEquals(1, punt.compareTo(punt2));
    }

    @Test
    public void compareTo_moet2Teruggeven_als_x_van_punt1_groter_is (){
        assertEquals(2, punt2.compareTo(punt));
    }

    @Test
    public void compareTo_moet1Teruggeven_als_x_gelijk_is_en_y_kleiner (){
        assertEquals(1, punt.compareTo(puntXGelijk));
    }

    @Test
    public void equals_moet_false_teruggeven_als_punt_verschillende_x_coordinaat_heeft(){
        Punt puntAnder = new Punt(xCoordinaat-1, yCoordinaat);
        assertFalse(punt.equals(puntAnder));
    }

    @Test
    public void equals_moet_false_teruggeven_als_punt_verschillende_y_coordinaat_heeft(){
        Punt puntAnder = new Punt(xCoordinaat, yCoordinaat-1);
        assertFalse(punt.equals(puntAnder));
    }
}