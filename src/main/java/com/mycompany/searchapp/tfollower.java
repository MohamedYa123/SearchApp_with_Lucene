/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author medo1
 */
        public class tfollower extends Thread{
        @Override
        public void run(){
          //  while (true){
            frm.settext(lt.indx_time+"\n"+lt.searching_msg);
            
           // frm.textlog.setText(frm.lt.indexing_msg+"\n"+frm.lt.searching_msg);
          //  System.out.println(frm.textlog.getText());
          //  frm.setTitle(frm.lt.indexing_msg+"\n"+frm.lt.searching_msg);
            try {
                Thread.sleep(100);
            } catch (InterruptedException |NullPointerException ex) {
                Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!lt.imdone){
            run();}
            else{
                frm.settext(lt.indx_time+"\n"+lt.searching_msg);
                frm.setresults(lt.ls);
            }
           // lasts=lt.searching_msg;
          //  }
        }
       public  frmresult frm;
       public LuceneTester lt;
       String lasts="";
    }
