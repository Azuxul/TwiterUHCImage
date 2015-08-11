package fr.azuxul.uhcimagestwiter;

/**
 * This enum contain backgrounds for images
 *
 * @author Azuxul
 * @version 1.0
 */
public enum Background {

    EXTREMEHILS("/assets/backgrounds/background5.png"),
    SWAPLAND("/assets/backgrounds/background4.png"),
    OCEAN("/assets/backgrounds/background3.png"),
    PLAN("/assets/backgrounds/background2.png"),
    NETHERPORTAL("/assets/backgrounds/background1.png"),
    NETHER("/assets/backgrounds/background0.png");

    private final String PATH;

    Background(String PATH){

        this.PATH = PATH;
    }

    /**
     * Return specific path of background
     *
     * @return path
     */
    public String getPath(){
        return PATH;
    }
}
