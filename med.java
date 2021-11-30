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
public class med {
    String name,address,comed,revid;

    public med(String name, String address, String comed, String revid) {
        this.name = name;
        this.address = address;
        this.comed = comed;
        this.revid = revid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComed() {
        return comed;
    }

    public void setComed(String comed) {
        this.comed = comed;
    }

    public String getRevid() {
        return revid;
    }

    public void setRevid(String revid) {
        this.revid = revid;
    }
    
}
