package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TekeningHangManTest {
    private TekeningHangMan tekeningHangMan;
    private Vorm dak;
    private Vorm hoofd;


    @Before
    public void setUp() {
        tekeningHangMan = new TekeningHangMan();
        dak = new Driehoek(new Punt(100, 200), new Punt(300, 200), new Punt(200, 100));
        hoofd = new Cirkel(new Punt(280, 125), 25);
    }

    @Test
    public void test_VoegToe_MagGeenEffectHebben(){
        int length = tekeningHangMan.getAantalVormen();
        tekeningHangMan.voegToe(dak);
        assertEquals(length, tekeningHangMan.getAantalVormen());
    }

    @Test
    public void test_Verwijder_MagGeenEffectHebben(){
        int length = tekeningHangMan.getAantalVormen();
        tekeningHangMan.verwijder(hoofd);
        assertEquals(length, tekeningHangMan.getAantalVormen());
    }
}
