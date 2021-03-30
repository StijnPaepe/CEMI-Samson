package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CirkelTest {
    private Punt geldigMiddelpunt;
    private int geldigRadius;

    @Before
    public void setUp() throws Exception {
        geldigMiddelpunt = new Punt(5,6);
        geldigRadius = 10;
    }

    @Test
    public void cirkel_Heeft_GeldigMiddelpunt_En_GeldigeStraal(){
        Cirkel cirkel = new Cirkel(geldigMiddelpunt, geldigRadius);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelpunt());
        assertEquals(geldigRadius, cirkel.getRadius());

    }

   @Test(expected = IllegalArgumentException.class)
    public void test_Cirkel_metMiddelpuntisNull_GooiIllegalArgumentException(){
        new Cirkel(null, geldigRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Cirkel_metNegatieveStraal_GooiIllegalArgumentException(){
        new Cirkel(geldigMiddelpunt, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Cirkel_metStraalis0_GooiIllegalArgumentException(){
        new Cirkel(geldigMiddelpunt, 0);
    }


    @Test
    public void test_tweeCirkels_MetDezelfdeStraalEnMiddelpunt(){
        Cirkel cirkel1 = new Cirkel(geldigMiddelpunt, geldigRadius);
        Cirkel cirkel2 = new Cirkel(geldigMiddelpunt, geldigRadius);
        assertEquals(cirkel1, cirkel2);
    }

    @Test
    public void test_verschillendWanneerTweedeCirkelNullis(){
        Cirkel cirkel1 = new Cirkel(geldigMiddelpunt, geldigRadius);
        Cirkel cirkel2 = null;
        assertFalse(cirkel1.equals(cirkel2));
    }

    @Test
    public void test_verschillendWanneerMiddelpuntVerschillendis() {
        Cirkel cirkel1 = new Cirkel(new Punt(5, 6), geldigRadius);
        Cirkel cirkel2 = new Cirkel(new Punt(4, 7), geldigRadius);
        assertFalse(cirkel1.equals(cirkel2));
    }

}
