package hu.unideb.inf.model;

import javax.persistence.*;

@Entity
public class User2 {
    private String vnev;

    @Basic
    public String getVnev() {
        return vnev;
    }

    public void setVnev(String vnev) {
        this.vnev = vnev;
    }

    private String knev;

    @Basic
    public String getKnev() {
        return knev;
    }

    public void setKnev(String knev) {
        this.knev = knev;
    }

    private String username;

    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String email;

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private String password;

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String datum;

    @Basic
    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    private int id;

    @GeneratedValue
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int nyereseg;

    @Basic
    public int getNyereseg() {
        return nyereseg;
    }

    public void setNyereseg(int nyereseg) {
        this.nyereseg = nyereseg;
    }

    private int veszteseg;

    @Basic
    public int getVeszteseg() {
        return veszteseg;
    }

    public void setVeszteseg(int veszteseg) {
        this.veszteseg = veszteseg;
    }

    private String CreditCardNumber;

    @Basic
    public String getCreditCardNumber() {
        return CreditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        CreditCardNumber = creditCardNumber;
    }

    private String setID;

    @Basic
    public String getSetID() {
        return setID;
    }

    public void setSetID(String setID) {
        this.setID = setID;
    }

    private String nem;

    @Basic
    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    private String Hajszin;

    @Basic
    public String getHajszin() {
        return Hajszin;
    }

    public void setHajszin(String hajszin) {
        Hajszin = hajszin;
    }

    private String szem;

    @Basic
    public String getSzem() {
        return szem;
    }

    public void setSzem(String szem) {
        this.szem = szem;
    }

    private int jatekospenz;

    @Basic
    public int getJatekospenz() {
        return jatekospenz;
    }

    public void setJatekospenz(int jatekospenz) {
        this.jatekospenz = jatekospenz;
    }

    private int jatekospenz2;

    @Basic
    public int getJatekospenz2() {
        return jatekospenz2;
    }

    public void setJatekospenz2(int jatekospenz2) {
        this.jatekospenz2 = jatekospenz2;
    }

    private String jatekos_hajszem;

    @Basic
    public String getJatekos_hajszem() {
        return jatekos_hajszem;
    }

    public void setJatekos_hajszem(String jatekos_hajszem) {
        this.jatekos_hajszem = jatekos_hajszem;
    }

    private String jatekos_neme;

    @Basic
    public String getJatekos_neme() {
        return jatekos_neme;
    }

    public void setJatekos_neme(String jatekos_neme) {
        this.jatekos_neme = jatekos_neme;
    }

    private int kellekek0;

    @Basic
    public int getKellekek0() {
        return kellekek0;
    }

    public void setKellekek0(int kellekek0) {
        this.kellekek0 = kellekek0;
    }

    private int kellekek1;

    @Basic
    public int getKellekek1() {
        return kellekek1;
    }

    public void setKellekek1(int kellekek1) {
        this.kellekek1 = kellekek1;
    }

    private int kellekek2;

    @Basic
    public int getKellekek2() {
        return kellekek2;
    }

    public void setKellekek2(int kellekek2) {
        this.kellekek2 = kellekek2;
    }

    private int kellekek3;

    @Basic
    public int getKellekek3() {
        return kellekek3;
    }

    public void setKellekek3(int kellekek3) {
        this.kellekek3 = kellekek3;
    }
}
