package game;

import game.charactor.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class PracticeGui{
    private JPanel Practice;
    private JLabel lblCharactor;
    private JLabel lblkillnum;
    private JLabel lblname;
    private JList list1;
    private JButton fightButton;
    private JLabel lblkill;
    private JLabel lblHP;
    private JLabel lblStamina;
    private JPanel pnlMons;
    private JLabel lblstamina_val;
    private JLabel lblHP_val;
    private JLabel lblGenDef;
    private JLabel lblStamrate;
    private JLabel lblMonsname;
    private JLabel lblMonsHp;
    private JLabel lblMonsAtk;
    private JLabel lblMonsDef;
    private JLabel lblMonspos;
    private JList skilllist;
    private JButton button1;
    private JTextPane textPane1;
    private JTextPane Skilllist;
    private JLabel lblsklst;
    private ArrayList<Monster> monslist = new ArrayList<Monster>();

    public PracticeGui(Novice player){
        lblHP_val.setText(Integer.toString(player.get_hp()));
        lblname.setText(player.getName());
        lblstamina_val.setText(Integer.toString(player.get_stamina()));
        lblGenDef.setText(Integer.toString(player.get_def()));
        lblStamrate.setText(Integer.toString(player.getStamina_rate()));
        if(player.get_skill_list(player) != null)
            skilllist.setListData(player.get_skill_list(player));
        Monster thanaton = new Monster("Thanaton",270,140,20);
        Monster sudarit = new Monster("Sudarit",650,110,60);
        Monster mingkhan = new Monster("Mingkhan",450, 100,50);
        Monster pruyut = new Monster("Pruyut",550,140,100);
        Monster prawit = new Monster("Prawish",675,160,120);
        Monster aprilat = new Monster("Aprilat", 420,180,100);
        monslist.add(thanaton);
        monslist.add(sudarit);
        monslist.add(mingkhan);
        monslist.add(pruyut);
        monslist.add(prawit);
        monslist.add(aprilat);
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String search = (String) list1.getSelectedValue();
                for(Monster d : monslist){
                    if(d.getName() != null && d.getName().contains(search)){
                        lblMonsname.setText(d.getName());
                        lblMonsHp.setText(Integer.toString(d.getHp()));
                        lblMonsAtk.setText(Integer.toString(d.getAtk()));
                        lblMonsDef.setText(Integer.toString(d.getDef()));
                        lblMonspos.setText(d.getPosition());
                    }

                }
            }
        });
    }

    public void load(Novice player){
        JFrame frame = new JFrame("Practice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PracticeGui(player).Practice);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
