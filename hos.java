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
public class hos {
    String name,address;
    int beds,icb,vb,tc,ac;
    String rid;

    public hos(String name, String address, int beds, int icb, int vb,int tc,int ac, String rid) {
        this.name = name;
        this.address = address;
        this.beds = beds;
        this.icb = icb;
        this.vb = vb;
        this.ac = ac;
        this.rid = rid;
        this.tc=tc;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
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

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getIcb() {
        return icb;
    }

    public void setIcb(int icb) {
        this.icb = icb;
    }

    public int getVb() {
        return vb;
    }

    public void setVb(int vb) {
        this.vb = vb;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
    
}
