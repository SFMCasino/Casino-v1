/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

/**
 *
 * @author XeroFox
 */
public class FelhasznaloProfile {
    String Felhasználó;
    String Jelszó;
    String ID;

    public FelhasznaloProfile(String Felhasználó, String Jelszó) {
        this.Felhasználó = Felhasználó;
        this.Jelszó = Jelszó;
    }

    public FelhasznaloProfile(String Felhasználó, String Jelszó, String ID) {
        this.Felhasználó = Felhasználó;
        this.Jelszó = Jelszó;
        this.ID = ID;
    }
     
}
