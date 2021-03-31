package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LijnStukTest {
    private Punt punt1 = new Punt(10, 20);
    private Punt zelfdeAlsPunt1 = new Punt(10, 20);
    private Punt punt2 = new Punt(190, 30);
    private Punt zelfdeAlsPunt2 = new Punt(190, 30);

    @Test
    public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
        LijnStuk lijnstuk = new LijnStuk(punt1, punt2);

        assertEquals(punt1, lijnstuk.getStartPunt());
        assertEquals(punt2, lijnstuk.getEindPunt());
    }

    @Test (expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_startpunt_null()  {
        new LijnStuk(null, punt2);
    }

    @Test (expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_eindpunt_null()  {
        new LijnStuk(punt1, null);
    }

    @Test (expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_eindpunt_en_startpunt_gelijk_zijn()  {
        new LijnStuk(punt1, punt1);
    }

    @Test
    public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn(){
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        LijnStuk zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt1, zelfdeAlsPunt2);
        assertTrue(lijnStuk.equals(zelfdeLijnStuk));
    }

    @Test
    public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn_in_foute_volgorde(){
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        LijnStuk zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt2, zelfdeAlsPunt1);
        assertTrue(lijnStuk.equals(zelfdeLijnStuk));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        assertFalse(lijnStuk.equals(null));
    }

    @Test
    public void test_getOmhullende_geeftCorrectOmhullendeFiguur() {
        LijnStuk lijnStuk = new LijnStuk(new Punt(100, 150), new Punt(200, 250));
        Omhullende omhullende = lijnStuk.getOmhullende();
        assertEquals(new Omhullende(new Punt(100, 250), 100, 100), omhullende);
    }
}