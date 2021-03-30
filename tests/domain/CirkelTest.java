package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CirkelTest {
    private Punt geldigMiddelpunt;
    private int geldigRadius;

    @Before
    public void setUp() {
        geldigMiddelpunt = new Punt(5,6);
        geldigRadius = 10;
    }

    @Test
    public void cirkel_Heeft_GeldigMiddelpunt_En_GeldigeStraal(){
        Cirkel cirkel = new Cirkel(geldigMiddelpunt, geldigRadius);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelpunt());
        assertEquals(geldigRadius, cirkel.getRadius());

    }

   @Test(expected = DomainException.class)
    public void test_Cirkel_metMiddelpuntIsNull_GooiIllegalArgumentException(){
        new Cirkel(null, geldigRadius);
    }

    @Test(expected = DomainException.class)
    public void test_Cirkel_metNegatieveStraal_GooiIllegalArgumentException(){
        new Cirkel(geldigMiddelpunt, -4);
    }

    @Test(expected = DomainException.class)
    public void test_Cirkel_metStraalIs0_GooiIllegalArgumentException(){
        new Cirkel(geldigMiddelpunt, 0);
    }


    @Test
    public void test_tweeCirkels_MetDezelfdeStraalEnMiddelpunt(){
        Cirkel cirkel1 = new Cirkel(geldigMiddelpunt, geldigRadius);
        Cirkel cirkel2 = new Cirkel(geldigMiddelpunt, geldigRadius);
        assertEquals(cirkel1, cirkel2);
    }

    @Test
    public void test_verschillendWanneerTweedeCirkelNullIs(){
        Cirkel cirkel1 = new Cirkel(geldigMiddelpunt, geldigRadius);
        assertNotEquals(cirkel1, null);
    }

    @Test
    public void test_verschillendWanneerMiddelpuntVerschillendIs() {
        Cirkel cirkel1 = new Cirkel(new Punt(5, 6), geldigRadius);
        Cirkel cirkel2 = new Cirkel(new Punt(4, 7), geldigRadius);
        assertNotEquals(cirkel1, cirkel2);
    }

}
