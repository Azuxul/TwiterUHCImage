package fr.azuxul.uhcimagestwiter;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Panel contain images for window
 *
 * @author Azuxul
 * @version 1.1
 */
public class Panel extends JPanel {

    /**
     * Paint images(logo and twiter image)
     * If Main.save save twiter image
     *
     * @param g Graphics for print images
     */
    public void paintComponent(Graphics g){

        Image img = null;
        Image logo = null;
        String name = Main.getWindow().textName.getText().length() <= 0?"NAME":Main.getWindow().textName.getText();
        String team = Main.getWindow().textTeam.getText().length() <=0?"FFA":Main.getWindow().textTeam.getText().equalsIgnoreCase("RVB")?"RvB":"FFA";
        String date = Main.getWindow().textDate.getText().length() <= 0?"DATE":Main.getWindow().textDate.getText();
        String sc1 = Main.getWindow().textSc.getText().length() <= 0?"SCENARIOS":Main.getWindow().textSc.getText();
        String sc2 = "";
        String ip = Main.getWindow().textIp.getText().length() <= 0?"IP":Main.getWindow().textIp.getText();
        String open = Main.getWindow().textOpen.getText().length() <= 0?"OPENTIME":Main.getWindow().textOpen.getText();
        String start = Main.getWindow().textStart.getText().length() <= 0?"STARTTIME":Main.getWindow().textStart.getText();

        try{
            team = Integer.parseInt(Main.getWindow().textTeam.getText()) <= 0?"FFA":"To"+Main.getWindow().textTeam.getText();
        }
        catch (Exception ignored){}

        if(Main.backgroundIndex <= -1){

            Main.backgroundIndex = new Random().nextInt(Background.values().length);
        }

        try {
            img = ImageIO.read(Main.class.getResource(Background.values()[Main.backgroundIndex].getPath()));
            logo = ImageIO.read(Main.class.getResource("/assets/textures/azuxulLogo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Separate string to two strings if is to long
        if(sc1.length() >= 30){

            List<Integer> indexForPossibleStringCut = new ArrayList<>();
            int cutIndex = 0;

            for(int i = sc1.length() - 1; i >= 0; i--)
                if(sc1.charAt(i) == '-' || sc1.charAt(i) == ' ' || sc1.charAt(i) == '/')
                    indexForPossibleStringCut.add(i);

            for(Integer i:indexForPossibleStringCut)
                if(i <= 31 && i > cutIndex)
                    cutIndex = i;

            sc2 = sc1.substring(cutIndex + 1, sc1.length());
            sc1 = sc1.substring(0, cutIndex + 1);
        }

        BufferedImage bufferedImage = new BufferedImage(440, 220, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2D = bufferedImage.createGraphics();
        g2D.drawImage(img, 0, 0, bufferedImage.getWidth() * (bufferedImage.getWidth() * 100 / 440) / 100, bufferedImage.getHeight() * (bufferedImage.getHeight() * 100 / 220) / 100, this);

        g2D.setColor(new Color(55, 55, 55, 179));
        g2D.fillRoundRect(10, 10, 440 - 20, 220 - 20, 3, 3);

        g2D.setFont(new Font("Sans", 0, 10));
        g2D.setColor(Color.WHITE);
        g2D.drawString("Azuxul", 390, 205);
        g2D.setFont(new Font(g2D.getFont().getName(), g2D.getFont().getStyle(), 18));
        g2D.drawString(name + " " + team + " - " + date, 25, 35);
        g2D.drawString("- Scénarios: " +  sc1 , 25, 80); //Max char 30
        g2D.drawString(sc2, 25, 105);
        g2D.drawString("- Ip: " + ip, 25, 130);
        g2D.drawString("- Ouverture: " + open, 25, 155);
        g2D.drawString("- Start: " + start, 25, 180);

        int imgX = (this.getWidth() - bufferedImage.getWidth())/32, imgY = (this.getHeight() - bufferedImage.getHeight())/2;
        g.drawImage(bufferedImage, imgX, imgY, this);
        g.drawImage(logo, 855, imgY, 155, 155, this);

        if(Main.save){

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
            fileChooser.setSelectedFile(new File("uhc.png"));
            fileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    try {
                        return f.isDirectory() || f.getName().substring(f.getName().length() - 4).equalsIgnoreCase(".png") || f.getName().substring(f.getName().length() - 4).equalsIgnoreCase(".lnk");
                    } catch (Exception e) {
                        return false;
                    }
                }

                @Override
                public String getDescription() {
                    return "Image png (.png)";
                }
            });
            int r = fileChooser.showSaveDialog(this);

            if(r == JFileChooser.APPROVE_OPTION){

                try {
                    ImageIO.write(bufferedImage, "PNG", fileChooser.getSelectedFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            Main.save = false;
        }
    }
}
