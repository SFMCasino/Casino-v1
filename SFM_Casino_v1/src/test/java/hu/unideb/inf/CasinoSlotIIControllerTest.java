package hu.unideb.inf;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import junit.framework.TestCase;


import static org.junit.Assert.assertArrayEquals;

public class CasinoSlotIIControllerTest extends TestCase {

    public void testNyeremeny() {
        String[] Kellekek = new String[] {"2","1","0","1"};
        int kellek = 3;
        CasinoSlotIIController instance = new CasinoSlotIIController();
        int expected = 2000;
        char[][] k = {{'a','o','o','r','w'},{'j','q','r','j','r'},{'r','r','r','r','m'}};
        int result = instance.nyeremeny(k);
        assertEquals(expected, result);
    }

    public void testKiszamol() {
        int expected = 200;
        char be = 'a';
        int mennyi = 4;
        CasinoSlotIIController instance = new CasinoSlotIIController();
        int result = instance.kiszamol(mennyi, be);
        assertEquals(expected, result);

    }

    /*
    public void testKepbeallitas() {
        Image expected;
        expected = new Image("/icons/Owl.png");
        CasinoSlotIIController instance = new CasinoSlotIIController();
        Image result = instance.kepbeallitas('o');
        ImageView exp = new ImageView();
        exp.setImage(expected);
        ImageView res = new ImageView();
        res.setImage(result);
        assertEquals(exp, res);
    }
     */
}