package game;

import game.charactor.Monster;
import game.charactor.Novice;
import game.charactor.Skill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static game.PracticeGui.getRandom;

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
    private JLabel p1cost;
    private JLabel p2cost;
    private int turn = 1;
    private int rand = (int)(Math.random() * 100);
    private Novice p1,p2;
    private double[] multiplier = new double[]{0.0,0.8,0.8,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.2,1.2,1.5,2.0};

    public FightGui(Novice player1,Novice player2){
        p1 = player1;
        p2 = player2;
        p1.setStamina(p1.get_stamina()/2);
        p2.setStamina(p2.get_stamina()/2);
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
        battlelog.setText("+++++++++++++++++++++ Turn "+ turn +" +++++++++++++++++++++\n(Player 1) " + p1.getName() + "'s Health : " + p1.get_hp() + "\n(Player 2) " + p2.getName() + "'s Health : " + p2.get_hp());


        if(rand % 2 == 0){
            //p1 first
            JLabel label = new JLabel("Player 1 First!");
            label.setFont(new Font("Century Gothic", Font.PLAIN, 56));
            JOptionPane.showMessageDialog(null, label,"Battle!",JOptionPane.PLAIN_MESSAGE);
            skillp1.setEnabled(true);
            skillp2.setEnabled(false);
            attackp1.setEnabled(true);
            attackp2.setEnabled(false);
            battlelog.setText(battlelog.getText() + "\n --------------- Player 1 turn! ---------------");
        }else{
            //p2 first
            JLabel label = new JLabel("Player 2 First!");
            label.setFont(new Font("Century Gothic", Font.PLAIN, 56));
            JOptionPane.showMessageDialog(null, label,"Battle!",JOptionPane.PLAIN_MESSAGE);
            skillp2.setEnabled(true);
            skillp1.setEnabled(false);
            attackp2.setEnabled(true);
            attackp1.setEnabled(false);
            battlelog.setText(battlelog.getText() + "\n --------------- Player 2 turn! ---------------");
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
        attackp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:: p1 attack!
                attackp1.setEnabled(false);
                skillp1.setEnabled(false);
                int selected = skillp1.getSelectedIndex();
                Skill usethis = p1.getSkills()[selected];
                double multiply = getRandom(multiplier);
                if (usethis.getStamina_cost() > p1.get_stamina()) {
                    JOptionPane.showMessageDialog(
                            null, "Not enough stamina!", "Error", JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    p1.setStamina(p1.get_stamina() - usethis.getStamina_cost());
                    battlelog.setText(
                            battlelog.getText() + "\n" + "Player 1 uses \"" + p1.get_skill_list()[selected] + "\"\n" + "Cost: " + usethis.getStamina_cost()
                    );
                    update();
                    if(usethis.getType().equals("damage")) {
                        if(p2.isBlocked()){
                            battlelog.setText(
                                    battlelog.getText() + "\nPlayer 2 blocking..."
                            );
                            if(multiply >= 1.5){
                                battlelog.setText(
                                        battlelog.getText() + "\n" + "Block Fail!"
                                );
                                multiply = 1.0;
                            }else if(multiply >= 1.0){
                                battlelog.setText(
                                        battlelog.getText() + "\n" + "Blocked!"
                                );
                                multiply = usethis.getBlock_multipiler();
                            }else if(multiply < 1) {
                                if(!p1.isBluffed())
                                    battlelog.setText(
                                            battlelog.getText() + "\n" + "Flawless Block!"
                                    );
                                    multiply = 0.0;
                                }else {
                                    battlelog.setText(
                                            battlelog.getText() + "\n" + "Block!"
                                    );
                                    multiply = usethis.getBlock_multipiler();
                                }
                        }
                        if (p1.isBluffed()) {
                            multiply = multiply * p1.getbluff_multipiler();
                            p1.setBluffed(false);
                        }else if (multiply >= 2) {
                            battlelog.setText(
                                    battlelog.getText() + "\n" + "Critical!"
                            );
                        }else if (multiply > 1) {
                            battlelog.setText(
                                    battlelog.getText() + "\n" + "Bonus Damage!"
                            );
                        }else if (multiply == 0) {
                            battlelog.setText(
                                    battlelog.getText() + "\n" + "Miss!"
                            );
                        }
                        p2.setBlocked(false);
                        System.out.println("Your final mulipiler : " + multiply);
                        p2.take_damage((int) (usethis.getDamage_deal() * multiply));
                        battlelog.setText(
                                battlelog.getText() + "\nPlayer 2 took " + usethis.getDamage_deal() * multiply + " damages."
                        );
                        battlelog.setText(
                                battlelog.getText() + "\nPlayer 1's turn ends:\n" + p1.getName() + "'s Health : " + p1.get_hp() + "\nPlayer 2's Health : " + p2.get_hp()
                        );

                    } else if (usethis.getType().equals("block")) {
                        p1.setBlocked(true);
                        battlelog.setText(
                                battlelog.getText() + "\nBlock!"
                        );
                        if (p1.isBluffed()) {
                            battlelog.setText(
                                    battlelog.getText() + "\nWarning: Bluff lost!"
                            );
                            p1.setBluffed(false);
                        }
                        p1.setBluffed(false);
                    } else if (usethis.getType().equals("bluff")) {
                        if (p1.isBluffed()) {
                            JOptionPane.showMessageDialog(
                                    null, "Already Bluffed!", "Warning", JOptionPane.WARNING_MESSAGE
                            );
                            attackp1.setEnabled(true);
                            skillp1.setEnabled(true);
                            return;
                        } else {
                            p1.setBluffed(true);
                            battlelog.setText(
                                    battlelog.getText() + "\nYour attack will increase next turn."
                            );
                        }
                    }
                }
                if(p2.isDead()){
                    //TODO:: p2 dead p1 wins
                    JLabel label = new JLabel("Player 1 wins!");
                    label.setFont(new Font("Century Gothic", Font.PLAIN, 75));
                    JOptionPane.showMessageDialog(null,label,"Battle Ends",JOptionPane.PLAIN_MESSAGE);
                    battlelog.setText(battlelog.getText() + "\nPlayer 1 wins!");
                    battlelog.setText(battlelog.getText() + "\n +++++++++++++++++++++ Battle Ends +++++++++++++++++++++\n");
                    update();
                    p1.re_stat();
                    p2.re_stat();
                    attackp1.setEnabled(false);
                    attackp2.setEnabled(false);
                    skillp1.setEnabled(false);
                    skillp2.setEnabled(false);
                    battlelog.setEnabled(false);
                    return;
                }
                update();
                if(!p1.isDead() && !p2.isDead()){
                    turn++;
                    battlelog.setText(battlelog.getText() + "\n+++++++++++++++++++++ Turn "+ turn +" +++++++++++++++++++++\n(Player1) " + p1.getName() + "'s Health : " + p1.get_hp() + "\n(Player2) " + p2.getName() + "'s Health : " + p2.get_hp());
                    battlelog.setText(battlelog.getText() + "\n --------------- Player 2 turn! ---------------");

                }
                attackp2.setEnabled(true);
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

    public void update(){
        p1HP_val.setText(Integer.toString(p1.get_hp()));
        p2HP_val.setText(Integer.toString(p2.get_hp()));
        p1stamina_val.setText(Integer.toString(p1.get_stamina()));
        p2stamina_val.setText(Integer.toString(p2.get_stamina()));
    }
}

