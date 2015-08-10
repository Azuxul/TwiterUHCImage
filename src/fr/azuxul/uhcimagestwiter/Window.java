package fr.azuxul.uhcimagestwiter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Azuxul on 09/08/2015.
 */
public class Window {

    private JFrame frame;
    private JPanel panel;
    public JButton buttonSave;
    public JFormattedTextField textName;
    public JFormattedTextField textTeam;
    public JFormattedTextField textDate;
    public JFormattedTextField textIp;
    public JFormattedTextField textSc;
    public JFormattedTextField textOpen;
    public JFormattedTextField textStart;
    public JLabel labelName;
    public JLabel labelTeamSize;
    public JLabel labelDate;
    public JLabel labelIP;
    public JLabel labelSc;
    public JLabel labelStart;
    public JLabel labelOpen;
    public JLabel labelCredits;

    public Window(int HEIGHT, int WEIGHT, String TITLE){

        frame = new JFrame(TITLE);

        frame.setSize(HEIGHT, WEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(720, 275));
        frame.setResizable(false);

        panel = new Panel();
        frame.setContentPane(panel);

        addComponent();

        frame.setVisible(true);

    }

    public void update(){

        frame.validate();
        frame.repaint();
    }

    private void addComponent() {

        ActionListener listenerSave = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Main.save = true;
                update();
            }

        };

        ActionListener listenerReset = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Main.save = false;
                Main.backgrondIndex = -1;
                textName.setText("");
                textTeam.setText("");
                textDate.setText("");
                textSc.setText("");
                textIp.setText("");
                textStart.setText("");
                textOpen.setText("");
                update();
            }

        };

        buttonSave = new JButton("Export file as .png");
        textName = new JFormattedTextField();
        textTeam = new JFormattedTextField();
        textDate = new JFormattedTextField();
        textSc = new JFormattedTextField();
        textIp = new JFormattedTextField();
        textStart = new JFormattedTextField();
        textOpen = new JFormattedTextField();
        labelName = new JLabel("Name :");
        labelTeamSize = new JLabel("Team size (RvB=RvB, FFA=0) :");
        labelDate = new JLabel("Date :");
        labelSc = new JLabel("Scénarios :");
        labelIP = new JLabel("Ip:");
        labelOpen = new JLabel("Ouverture :");
        labelStart = new JLabel("Start :");
        labelCredits = new JLabel("http://azuxul.free.fr/ \t - \t https://github.com/Azuxul/ \t - \t @Azuxul");

        int defaultX = ((frame.getWidth() - 440) / 10) + 440;

        panel.setLayout(null);

        buttonSave.setBounds(defaultX, 205, (frame.getWidth() - ((frame.getWidth() - 440) / 32) * 2 + 440) / 3, 30);
        buttonSave.addActionListener(listenerSave);
        panel.add(buttonSave);

        labelName.setBounds(defaultX, 15, ((frame.getWidth() - ((frame.getWidth() - 440) / 32) * 2 + 440) / 8), 25);
        panel.add(labelName);

        textName.setBounds(((frame.getWidth() - 440) / 10) + 500, 15, ((frame.getWidth() - ((frame.getWidth() - 440) / 32) * 2 + 440) / 5), 20);
        textName.getDocument().addDocumentListener(new UpdateListener());
        panel.add(textName);

        labelTeamSize.setBounds(defaultX, 40, 155, 25);
        panel.add(labelTeamSize);

        textTeam.setBounds(defaultX + 155, 40, 30, 20);
        textTeam.getDocument().addDocumentListener(new UpdateListener());
        panel.add(textTeam);

        labelDate.setBounds(defaultX + 205, 40, 30, 25);
        panel.add(labelDate);

        textDate.setBounds(defaultX + 245, 40, 100, 20);
        textDate.getDocument().addDocumentListener(new UpdateListener());
        panel.add(textDate);

        labelSc.setBounds(defaultX, 65, 55, 25);
        panel.add(labelSc);

        textSc.setBounds(defaultX + 60, 65, 285, 20);
        textSc.getDocument().addDocumentListener(new UpdateListener());
        panel.add(textSc);

        labelIP.setBounds(defaultX, 90, 20, 25);
        panel.add(labelIP);

        textIp.setBounds(defaultX + 25, 90, 320, 20);
        textIp.getDocument().addDocumentListener(new UpdateListener());
        panel.add(textIp);

        labelOpen.setBounds(defaultX, 115, 60, 25);
        panel.add(labelOpen);

        textOpen.setBounds(defaultX + 65, 115, 115, 20);
        textOpen.getDocument().addDocumentListener(new UpdateListener());
        panel.add(textOpen);

        labelStart.setBounds(defaultX + 190, 115, 35, 25);
        panel.add(labelStart);

        textStart.setBounds(defaultX + 230, 115, 115, 20);
        textStart.getDocument().addDocumentListener(new UpdateListener());
        panel.add(textStart);

        labelCredits.setBounds(defaultX, 180, (frame.getWidth() - ((frame.getWidth() - 440) / 32) * 2 + 440) / 3, 25);
        panel.add(labelCredits);
    }

}

class UpdateListener implements DocumentListener {

    @Override
    public void insertUpdate(DocumentEvent e) {
        Main.getWindow().update();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        Main.getWindow().update();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        Main.getWindow().update();
    }
}

