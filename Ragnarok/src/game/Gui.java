package game;

import game.charactor.klass.Blade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.PreferenceChangeEvent;

public class Gui{
    private JPanel MainGui;
    private JLabel lblChoose;
    private JButton btnPractice;
    private JButton btnPlay;
    public static JFrame frame;
    public JFrame practice;

    public Gui() {
        btnPractice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CharacterListGui(0).load();
                JFrame current = (JFrame) SwingUtilities.getWindowAncestor(MainGui);
                current.dispose();
            }
        });
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CharacterListGui(1).load();
                JFrame current = (JFrame) SwingUtilities.getWindowAncestor(MainGui);
                current.dispose();
            }
        });
    }

    public void load(){
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Gui().MainGui);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Gui().load();

    }
}
