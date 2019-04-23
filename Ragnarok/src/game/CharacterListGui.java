package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;



import static game.Gui.frame;
import game.Gui.*;
import game.charactor.Novice;
import game.charactor.klass.*;

public class CharacterListGui{
    private JList lstPlayer1Select;
    private JList lstPlayer2Select;
    private JLabel lblPlayer1;
    private JPanel choosechar;
    private JButton backButton;
    private JButton goButton;
    private JLabel lblPlayer2;
    private int type; // 0 for practice 1 for two player
    private String[] charactorlist = {"Blade","Nexus","Tyrant","Protektor","Psycho","Bomberman","Varoni","Handshadow"};
    public CharacterListGui(int mode){
        lstPlayer1Select.setSelectedIndex(0);
        lstPlayer2Select.setSelectedIndex(0);
        lstPlayer1Select.setListData(charactorlist);
        lstPlayer2Select.setListData(charactorlist);
        type = mode;
        if(type == 0){
            System.out.println(type);
            lstPlayer2Select.setEnabled(false);
            lstPlayer1Select.setEnabled(true);
        }else if(type == 1){

            lstPlayer2Select.setEnabled(true);
            lstPlayer1Select.setEnabled(true);
        }
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui a = new Gui();
                a.load(a);
                JFrame current = (JFrame) SwingUtilities.getWindowAncestor(choosechar);
                current.dispose();
            }
        });
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = (String) lstPlayer1Select.getSelectedValue();
                String p2 = (String) lstPlayer2Select.getSelectedValue();
                if(type == 0){
                    if(p1 == null){
                        JOptionPane.showMessageDialog(null, "Choose Player 1 Character", "Warning", JOptionPane.WARNING_MESSAGE);
                    }else{

                        try {
                            System.out.println(p1);
                            PracticeGui a = new PracticeGui((Novice)generate("game.charactor.klass." + p1));
                            a.load(a);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        JFrame current = (JFrame) SwingUtilities.getWindowAncestor(choosechar);
                        current.dispose();
                    }
                }else if(type == 1){
                    if(p1 == null){
                        JOptionPane.showMessageDialog(null, "Choose Player 1 Character", "Warning", JOptionPane.WARNING_MESSAGE);
                    }else if(p2 == null){
                        JOptionPane.showMessageDialog(null, "Choose Player 2 Character", "Warning", JOptionPane.WARNING_MESSAGE);
                    }else{
                        JLabel label = new JLabel(p1.toUpperCase() + " vs. " + p2.toUpperCase());
                        label.setFont(new Font("Century Gothic", Font.PLAIN, 75));
                        JOptionPane.showMessageDialog(null, label,"Battle!",JOptionPane.PLAIN_MESSAGE);
                        try {
                            FightGui a = new FightGui((Novice)generate("game.charactor.klass." + p1),(Novice)generate("game.charactor.klass." + p2));
                            a.load(a);
                            JFrame current = (JFrame) SwingUtilities.getWindowAncestor(choosechar);
                            current.dispose();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void load(CharacterListGui ui){
        JFrame frame = new JFrame("Choose Character");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(ui.choosechar);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.pack();
        frame.setVisible(true);
    }

    public static Object generate(String className) throws Exception {
        // Load the class.
        Class<?> clazz = Class.forName(className);
        // Search for an "appropriate" constructor.
//        Constructor<?> ctor = clazz.getConstructor(String.class);
        return clazz.newInstance();
    }

}
