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
public class auditor {
    String audid,Audname,audphno,piniss,pinass;
    int activity;

    public auditor(String audid, String Audname, String audphno, String piniss, String pinass, int activity) {
        this.audid = audid;
        this.Audname = Audname;
        this.audphno = audphno;
        this.piniss = piniss;
        this.pinass = pinass;
        this.activity = activity;
    }

    public String getAudid() {
        return audid;
    }

    public void setAudid(String audid) {
        this.audid = audid;
    }

    public String getAudname() {
        return Audname;
    }

    public void setAudname(String Audname) {
        this.Audname = Audname;
    }

    public String getAudphno() {
        return audphno;
    }

    public void setAudphno(String audphno) {
        this.audphno = audphno;
    }

    public String getPiniss() {
        return piniss;
    }

    public void setPiniss(String piniss) {
        this.piniss = piniss;
    }

    public String getPinass() {
        return pinass;
    }

    public void setPinass(String pinass) {
        this.pinass = pinass;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    
    
    
}
