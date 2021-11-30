/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidsos1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Anirudh Pandita
 */
public class getcurrentrev {

    public static void writetofile(int i){
        String strFilePath = "D://FileIO//readInt.txt";

        try {

            FileOutputStream fos = new FileOutputStream(strFilePath);

            DataOutputStream dos = new DataOutputStream(fos);

           

            dos.writeInt(i);

            dos.close();

        } catch (IOException e) {
            System.out.println("IOException : " + e);
        }
    }

    public static int readfromfile() {
        String strFilePath = "D://FileIO//readInt.txt";
         int i = 0;
        try {

            FileInputStream fin = new FileInputStream(strFilePath);
            DataInputStream din = new DataInputStream(fin);
            i = din.readInt();
           // System.out.println("int : " + i);
            din.close();
            

        } catch (FileNotFoundException fe) {
            System.out.println("FileNotFoundException : " + fe);
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe);
        }
        return i;
        
    }

}


