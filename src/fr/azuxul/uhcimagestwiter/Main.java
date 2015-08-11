package fr.azuxul.uhcimagestwiter;

import javax.swing.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.logging.Logger;

/**
 * Main class
 *
 * @author Azuxul
 * @version 1.0
 */
public class Main {

    public static boolean save = false;
    public static int backgrondIndex = -1;
    private static Window window;

    public static void main(String[] args){

        new Main();
    }

    public Main(){

        System.setProperty("file.encoding","UTF-8");
        try {
            Field charset;
            charset = Charset.class.getDeclaredField("defaultCharset");
            charset.setAccessible(true);
            charset.set(null,null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        window = new Window(1024, 280, "Twiter UHC image generator - Azuxul");
        Logger.getLogger("TwiterUHCImage").info("Starting complete !");
    }

    /**
     * Return main window
     *
     * @return window
     */
    public static Window getWindow(){

        return window;
    }
}
