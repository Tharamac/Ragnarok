package game;

import game.charactor.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
    private JList<String> skilllist;
    private JButton attackButton;
    private JTextPane Practicelog;
    private JButton backButton;
    private JTextPane Skilllist;
    private JLabel lblsklst;
    private ArrayList<Monster> monslist = new ArrayList<Monster>();
    private double[] multiplier = new double[]{0.0,0.8,0.8,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.2,1.2,1.5,2.0};

    public PracticeGui(Novice player){
        lblHP_val.setText(Integer.toString(player.get_hp()));
        lblname.setText(player.getName());
        lblstamina_val.setText(Integer.toString(player.get_stamina()));
        lblGenDef.setText(Integer.toString(player.get_def()));
        lblStamrate.setText(Integer.toString(player.getStamina_rate()));
        skilllist.setListData(player.get_skill_list());
        list1.setSelectedIndex(0);

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
        lblMonsname.setText(monslist.get(0).getName());
        lblMonsHp.setText(Integer.toString(monslist.get(0).getHp()));
        lblMonsAtk.setText(Integer.toString(monslist.get(0).getAtk()));
        lblMonsDef.setText(Integer.toString(monslist.get(0).getDef()));
        lblMonspos.setText(monslist.get(0).getPosition());



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
        fightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String challenger = player.getName();
                String opponent = (String) list1.getSelectedValue();
                player.setStamina(player.get_stamina()/2);

                JLabel label = new JLabel(challenger.toUpperCase() + " vs. " + opponent.toUpperCase());
                label.setFont(new Font("Century Gothic", Font.PLAIN, 75));
                JOptionPane.showMessageDialog(null, label,"Battle!",JOptionPane.PLAIN_MESSAGE);
                Monster enemy = new Monster("sa",55,5,5);
                for(Monster d : monslist) {
                    if (d.getName() != null && d.getName().contains(opponent)) {
                        enemy = d;
                    }
                }
                update(player,enemy);
                attackButton.setEnabled(true);
                fightButton.setEnabled(false);
                list1.setEnabled(false);
                skilllist.setEnabled(true);
                Practicelog.setText("Turn 01: \n" + challenger + "'s Health : " + player.get_hp() + "\n" + opponent + "'s Health : " + enemy.getHp());
                Practicelog.setText(Practicelog.getText() + "\n" + challenger + "'s turn!");

            }
        });
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attackButton.setEnabled(false);
                skilllist.setEnabled(false);
                int selected = skilllist.getSelectedIndex();
                Skill usethis = player.getSkills()[selected];
                String opponent = (String) list1.getSelectedValue();
                Monster enemy = new Monster("sa",55,5,5);
                double multiply = getRandom(multiplier);
                for(Monster d : monslist) {
                    if (d.getName() != null && d.getName().contains(opponent)) {
                        enemy = d;
                    }
                }
                update(player,enemy);

                if(usethis.getStamina_cost() > player.get_stamina()){
                    JOptionPane.showMessageDialog(
                            null, "Not enough stamina!","Error",JOptionPane.ERROR_MESSAGE
                    );
                } else{
                    player.setStamina(player.get_stamina() - usethis.getStamina_cost());
                    Practicelog.setText(
                            Practicelog.getText() + "\n" + "You use \"" + player.get_skill_list()[selected] +"\""
                    );
                    update(player,enemy);
                    if(usethis.getType() == "damage"){
                        System.out.println(multiply);
                        if(multiply >= 2){
                            Practicelog.setText(
                                    Practicelog.getText() + "\n" + "Critical!"
                            );
                        }else if(multiply > 1){
                            Practicelog.setText(
                                    Practicelog.getText() + "\n" + "Bonus Damage!"
                            );
                        }else if(multiply == 0){
                            Practicelog.setText(
                                    Practicelog.getText() + "\n" + "Miss!"
                            );
                        }
                        enemy.take_damage((int)(usethis.getDamage_deal()*multiply));
                        Practicelog.setText(
                                Practicelog.getText() + "\n" + enemy.getName() + " took " + usethis.getDamage_deal()*multiply + " damages from " + usethis.getName()
                        );
                        Practicelog.setText(
                                Practicelog.getText() + "\n" + player.getName() + "'s turn ends:\n"+ player.getName() + "'s Health : " + player.get_hp() + "\n" + opponent + "'s Health : " + enemy.getHp()
                        );

                    }
                    //enemy's turn
                    if(!enemy.isDead()){
                        Practicelog.setText(Practicelog.getText() + "\n" + enemy.getName() + "'s turn!");
                        multiply = (int) getRandom(multiplier);
                        System.out.println(multiply);
                        if(multiply >= 2){
                            Practicelog.setText(
                                    Practicelog.getText() + "\n" + "Critical!"
                            );
                        }else if(multiply > 1){
                            Practicelog.setText(
                                    Practicelog.getText() + "\n" + "Bonus Damage!"
                            );
                        }else if(multiply == 0){
                            Practicelog.setText(
                                    Practicelog.getText() + "\n" + "Miss!"
                            );
                        }
                        player.take_damage((int)(enemy.getAtk()* multiply));
                        Practicelog.setText(
                                Practicelog.getText() + "\n" + player.getName() + " attacks you " + (int)enemy.getAtk()*multiply + " damages from normal attack."
                        );
                        if(player.isDead()){
                            //TODO:: Battle ends, You lose.
                            JLabel label = new JLabel("You're dead. You lose.");
                            label.setFont(new Font("Century Gothic", Font.PLAIN, 75));
                            JOptionPane.showMessageDialog(null,label,"Battle Ends",JOptionPane.PLAIN_MESSAGE);
                        }else{
                            player.stamina_refill();
                        }
                    }else{
                        //TODO:: Battle ends, You wins.
                        JLabel label = new JLabel("Enemy is dead. You wins");
                        label.setFont(new Font("Century Gothic", Font.PLAIN, 75));
                        JOptionPane.showMessageDialog(null,label,"Battle Ends",JOptionPane.PLAIN_MESSAGE);
                    }
                }

                update(player,enemy);
                attackButton.setEnabled(true);
                skilllist.setEnabled(true);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CharacterListGui(0).load();
                JFrame current = (JFrame) SwingUtilities.getWindowAncestor(Practice);
                current.dispose();
            }
        });
    }

    public void load(Novice player){
        System.out.println(player.get_hp());
        JFrame frame = new JFrame("Practice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PracticeGui(player).Practice);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.pack();
        frame.setVisible(true);
    }

    public static double getRandom(double[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public void update(Novice player,Monster enemy){
        lblHP_val.setText(Integer.toString(player.get_hp()));
        lblstamina_val.setText(Integer.toString(player.get_stamina()));
        lblMonsHp.setText(Integer.toString(enemy.getHp()));
    }


}
