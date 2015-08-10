package fr.azuxul.uhcimagestwiter;

/**
 * Created by Azuxul on 10/08/2015.
 */
public enum Backgrond {

    EXTREMEHILS("/assets/backgronds/backgrond5.png"),
    SWAPLAND("/assets/backgronds/backgrond4.png"),
    OCEAN("/assets/backgronds/backgrond3.png"),
    PLAN("/assets/backgronds/backgrond2.png"),
    NETHERPORTAL("/assets/backgronds/backgrond1.png"),
    NETHER("/assets/backgronds/backgrond0.png");

    private String PATH;

    Backgrond(String PATH){

        this.PATH = PATH;
    }

    public String getPath(){
        return PATH;
    }
}
