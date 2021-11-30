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
public class call {
    String name,phno,hos,med,plas,food,id;
    int comp;

    public call(String name, String phno, String hos, String med, String plas, String food,String id, int comp) {
        this.name = name;
        this.phno = phno;
        this.hos = hos;
        this.med = med;
        this.plas = plas;
        this.food = food;
        this.id=id;
        this.comp = comp;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getHos() {
        return hos;
    }

    public void setHos(String hos) {
        this.hos = hos;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public String getPlas() {
        return plas;
    }

    public void setPlas(String plas) {
        this.plas = plas;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getComp() {
        return comp;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }
    
}
