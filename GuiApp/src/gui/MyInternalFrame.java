package gui;


import javax.swing.JInternalFrame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/* Used by InternalFrameDemo.java. */
public class MyInternalFrame extends JInternalFrame {
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    Container guiBeholder;
    private JButton gulKnapp;
    private JButton r�dKnapp;
    private JButton bl�Knapp;
    
    public MyInternalFrame() {
        super("Document #" + (++openFrameCount), 
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable

        //...Create the GUI and put it in the window...
        guiBeholder = getContentPane();
        int valg = (int) (Math.random() * 2) + 1;
        if (valg == 1) {
            MenyLytter lytteren = new MenyLytter();

            JMenu menyen = new JMenu("Farge");
            JMenuItem menypost = new JMenuItem("Gul");
            menyen.add(menypost);
            menypost.addActionListener(lytteren);

            menypost = new JMenuItem("R�d");
            menyen.add(menypost);
            menypost.addActionListener(lytteren);

            menypost = new JMenuItem("Bl�");
            menyen.add(menypost);
            menypost.addActionListener(lytteren);

            JMenuBar menylinje = new JMenuBar();
            menylinje.add(menyen);
            setJMenuBar(menylinje);
        }
        else {
            KnappeLytter lytteren = new KnappeLytter();
            JToolBar knapperad = new JToolBar();
            Icon ikon = new ImageIcon("gul.gif");
            gulKnapp = new JButton(ikon);
            gulKnapp.addActionListener(lytteren);
            knapperad.add(gulKnapp);

            ikon = new ImageIcon("roed.gif");
            r�dKnapp = new JButton(ikon);
            r�dKnapp.addActionListener(lytteren);
            knapperad.add(r�dKnapp);

            ikon = new ImageIcon("blaa.gif");
            bl�Knapp = new JButton(ikon);
            bl�Knapp.addActionListener(lytteren);
            knapperad.add(bl�Knapp);
    //        knapperad.addSeparator();

            guiBeholder.add(knapperad, BorderLayout.NORTH);
        }
      
        //...Then set the window size or call pack...
        setSize(300,300);
     
        
       

        //Set the window's location.
        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
    }
    private class MenyLytter implements ActionListener {
        public void actionPerformed(ActionEvent hendelse) {
            String kommando = hendelse.getActionCommand();
            if (kommando.equals("Gul")) guiBeholder.setBackground(Color.yellow);
            else if (kommando.equals("R�d")) guiBeholder.setBackground(Color.red);
            else guiBeholder.setBackground(Color.blue);
        }
    }
    
    private class KnappeLytter implements ActionListener {
        public void actionPerformed(ActionEvent hendelse) {
            JButton knapp = (JButton) hendelse.getSource();
            if (knapp == gulKnapp) guiBeholder.setBackground(Color.yellow);
            else if (knapp == r�dKnapp) guiBeholder.setBackground(Color.red);
            else guiBeholder.setBackground(Color.blue);
        }
    }

}

