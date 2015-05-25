/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.compani.finaz.lib.imagen;

import com.sun.deploy.uitoolkit.impl.fx.Utils;
import java.io.File;
import javax.swing.filechooser.*;
/**
 *
 * @author Angel Bencosme
 */

/* ImageFilter.java is used by FileChooserDemo2.java. */
public class FilterImageFormat extends FileFilter {

    //Accept all directories and all gif, jpg, tiff, or png files.
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = FilterExtensions.getExtension(f);
        if (extension != null) {
            if (extension.equals(FilterExtensions.TIFF) ||
                extension.equals(FilterExtensions.TIF) ||
                extension.equals(FilterExtensions.GIF) ||
                extension.equals(FilterExtensions.JPEG) ||
                extension.equals(FilterExtensions.JPG) ||
                extension.equals(FilterExtensions.PNG)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Just Images";
    }
}