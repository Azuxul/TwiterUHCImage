package fr.azuxul.uhcimagestwiter;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * Created by Azuxul on 09/08/2015.
 */
public class Main {

    public static boolean save = false;
    public static int backgrondIndex = -1;
    private static Window window;

    public static void main(String[] args){

        new Main();
    }

    public Main(){

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        window = new Window(1024, 280, "Twiter UHC image generator - Azuxul");
        Logger.getLogger("TwiterUHCImage").info("Starting complete !");
    }

    public static Window getWindow(){

        return window;
    }
}
