/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

/**
 *
 * @author medo1
 */
public class mythread extends Thread {
    @Override
    public void run(){
        lt.main(text,bol);
    }
    public LuceneTester lt; 
    public String text;
    public boolean bol;
}
