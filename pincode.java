/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidsos1;

/**
 *
 * @author Anirudh Pandita
 */
class pincode {
    String Officename;
    String Pincode;
    int endn;

    public pincode(String Officename, String Pincode, int endn) {
        this.Officename = Officename;
        this.Pincode = Pincode;
        this.endn = endn;
    }

    public String getOfficename() {
        return Officename;
    }

    public void setOfficename(String Officename) {
        this.Officename = Officename;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    public int getEndn() {
        return endn;
    }

    public void setEndn(int endn) {
        this.endn = endn;
    }
    
}
