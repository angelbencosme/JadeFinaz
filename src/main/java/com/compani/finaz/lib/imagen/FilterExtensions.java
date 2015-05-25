/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compani.finaz.lib.imagen;

import java.io.File;

/**
 *
 * @author Angel Bencosme
 */
public class FilterExtensions {

    public final static String JPEG = "jpeg";
    public final static String JPG = "jpg";
    public final static String GIF = "gif";
    public final static String TIFF = "tiff";
    public final static String TIF = "tif";
    public final static String PNG = "png";

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();

        int i = s.lastIndexOf('.');
//        return s.substring(i+1);

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }
    
//    public static void main(String[] args) {
//        
//        
//        System.out.println(getExtension(new File("foto_vaciones.")));   
//    }
}
