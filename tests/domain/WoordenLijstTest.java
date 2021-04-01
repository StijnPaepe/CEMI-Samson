package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class WoordenLijstTest {

    private WoordenLijst woordenlijstLeeg;
    private WoordenLijst woordenlijstMetEenGeldigWoord;
    private WoordenLijst woordenlijstMetGeldigeWoorden;
    private ArrayList<String> geldigeWoorden;

    @Before
    public void setUp() throws Exception {
        geldigeWoorden = new ArrayList<String>();
        geldigeWoorden.add("test");
        geldigeWoorden.add("game");
        geldigeWoorden.add("hangman");

        woordenlijstLeeg = new WoordenLijst();

        woordenlijstMetEenGeldigWoord = new WoordenLijst();
        woordenlijstMetEenGeldigWoord.voegToe(geldigeWoorden.get(0));

        woordenlijstMetGeldigeWoorden = new WoordenLijst();
        woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(0));
        woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(1));
        woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(2));

    }

    @Test
    public void WoordenLijst_moet_een_Woordenlijst_maken_zonder_woorden() {
        WoordenLijst woordenlijstLeeg = new WoordenLijst();
        assertEquals(0, woordenlijstLeeg.getAantalWoorden());
    }

    @Test
    public void voegToe_moet_een_woord_toevoegen() {
        woordenlijstLeeg.voegToe(geldigeWoorden.get(0));

        assertEquals(1, woordenlijstLeeg.getAantalWoorden());
    }

    @Test(expected = DomainException.class)
    public void test_voegToe_als_gegeven_woord_null_GooiDomainException() {
        woordenlijstLeeg.voegToe(null);
    }

    @Test(expected = DomainException.class)
    public void test_voegToe_als_gegeven_woord_leeg_GooiDomainException() {

        woordenlijstLeeg.voegToe("");
    }

    @Test(expected = DomainException.class)
    public void test_voegToe_als_gegeven_woord_reeds_in_lijst_Is_GooiDomainException() {
        String woordAlInLijst = geldigeWoorden.get(2);

        woordenlijstMetGeldigeWoorden.voegToe(woordAlInLijst);
    }

    @Test (expected = DomainException.class)
    public void test_getRandomWoord_als_legeLijst_GooiDomainException(){
        woordenlijstLeeg.getRandomWoord();
    }

   @Test
    public void test_getRandomWoord_Als_DeLijstHetRandomWoordBevat(){
        String test = woordenlijstMetGeldigeWoorden.getRandomWoord();
        assertTrue(woordenlijstMetGeldigeWoorden.containsWoord(test));

    }

    @Test
    public void test_getRandomWoord_Als_Het1WoordTeruggeeft(){
        woordenlijstLeeg.voegToe("Apple");

        assertEquals("Apple", woordenlijstLeeg.getRandomWoord());
    }
    //to do test 1 woord, return that woord
    // to do test multiple words, does the list contains the random word


}
