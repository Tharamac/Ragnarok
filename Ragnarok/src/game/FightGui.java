package game;

import game.charactor.Novice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FightGui {
    private JLabel lblCharactor;
    private JLabel p1name;
    private JLabel lblHP;
    private JLabel lblStamina;
    private JLabel p1HP_val;
    private JLabel p1stamina_val;
    private JLabel p1Def;
    private JLabel p1Stamrate;
    private JList skillp1;
    private JButton attackp1;
    private JList skillp2;
    private JButton attackp2;
    private JTextPane battlelog;
    private JPanel FightUI;
    private JLabel p2name;
    private JLabel p2HP_val;
    private JLabel p2stamina_val;
    private JLabel p2Stamrate;
    private JLabel p2Def;
    private JButton Cancel;
    private int turn = 1;
    private int rand = (int)(Math.random() * 100);

    public FightGui(Novice p1,Novice p2){

        p1HP_val.setText(Integer.toString(p1.get_hp()));
        p1name.setText(p1.getName());
        p1stamina_val.setText(Integer.toString(p1.get_stamina()));
        p1Def.setText(Integer.toString(p1.get_def()));
        p1Stamrate.setText(Integer.toString(p1.getStamina_rate()));
        skillp1.setListData(p1.get_skill_list());
        skillp1.setSelectedIndex(0);

        p2HP_val.setText(Integer.toString(p2.get_hp()));
        p2name.setText(p2.getName());
        p2stamina_val.setText(Integer.toString(p2.get_stamina()));
        p2Def.setText(Integer.toString(p2.get_def()));
        p2Stamrate.setText(Integer.toString(p2.getStamina_rate()));
        skillp2.setListData(p2.get_skill_list());
        skillp2.setSelectedIndex(0);
        battlelog.setText("+++++++++++++++++++++ Turn "+ turn +" +++++++++++++++++++++\n" + p1.getName() + "'s Health : " + p1.get_hp() + "\n" + p2.getName() + "'s Health : " + p2.get_hp());


        if(rand % 2 == 0){
            //p1 first
            JLabel label = new JLabel("Player 1 First!");
            label.setFont(new Font("Century Gothic", Font.PLAIN, 56));
            JOptionPane.showMessageDialog(null, label,"Battle!",JOptionPane.PLAIN_MESSAGE);
            skillp1.setEnabled(true);
            skillp2.setEnabled(false);
            attackp1.setEnabled(true);
            attackp2.setEnabled(false);
            battlelog.setText(battlelog.getText() + "\n --------------- Player 1 turn! : "+ p1.getName()+ " ---------------");


        }else{
            //p2 first
            JLabel label = new JLabel("Player 2 First!");
            label.setFont(new Font("Century Gothic", Font.PLAIN, 56));
            JOptionPane.showMessageDialog(null, label,"Battle!",JOptionPane.PLAIN_MESSAGE);
            skillp2.setEnabled(true);
            skillp1.setEnabled(false);
            attackp2.setEnabled(true);
            attackp1.setEnabled(false);
            battlelog.setText(battlelog.getText() + "\n --------------- Player 2 turn! : "+ p2.getName()+ " ---------------");
        }


        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui a = new Gui();
                a.load(a);
                JFrame current = (JFrame) SwingUtilities.getWindowAncestor(FightUI);
                current.dispose();
            }
        });
    }

    public void load(FightGui ui){
        JFrame frame = new JFrame("Battle!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(ui.FightUI);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.pack();
        frame.setVisible(true);
    }
}
