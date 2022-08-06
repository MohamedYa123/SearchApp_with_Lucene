/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.searchapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author medo1
 */
public class stat {
    public static String path="data.xy";
    public static allsearches recs;
    public static void save(){
        objectio obj=new objectio();
        obj.WriteObjectToFile(recs, path);
    }
    public static allsearches read() throws IOException, FileNotFoundException, ClassNotFoundException{
        objectio obj=new objectio();
        File f=new File(path);
        System.out.println(f.getAbsolutePath());
        recs=(allsearches)obj.read(path);
        return recs;
    }
}
