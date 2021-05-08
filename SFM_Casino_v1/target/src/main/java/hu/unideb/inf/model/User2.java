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
}
