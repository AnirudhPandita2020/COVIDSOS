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
public class reviewer {
    String name,id,phno,audselected;

    public reviewer(String name, String id, String phno, String audselected) {
        this.name = name;
        this.id = id;
        this.phno = phno;
        this.audselected = audselected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getAudselected() {
        return audselected;
    }

    public void setAudselected(String audselected) {
        this.audselected = audselected;
    }
    
}
