package hu.unideb.inf.controller;

import junit.framework.TestCase;

public class CasinoSlotIIControllerTest extends TestCase {

    public void testKiszamol() {
        int expected = 200;
        char be = 'a';
        int mennyi = 4;
        CasinoSlotIIController instance = new CasinoSlotIIController();
        int result = instance.kiszamol(mennyi, be);
        assertEquals(expected, result);
        System.out.println(expected + " " + result);
    }

    public void testNyeremeny() {
        String[] Kellekek = new String[] {"2","1","0","1"};
        int kellek = 3;
        CasinoSlotIIController instance = new CasinoSlotIIController();
        int expected = 2000;
        char[][] k = {{'a','o','o','r','w'},{'j','q','r','j','r'},{'r','r','r','r','m'}};
        int result = instance.nyeremeny(k);
        assertEquals(expected, result);
        System.out.println(expected + " " + result);
    }
}