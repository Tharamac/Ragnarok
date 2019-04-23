package game.charactor;


import game.info.Inventory;
import game.info.Item;

import java.util.ArrayList;

/*     Homework#1 30/01/2019
*      UPDATE:
*      My Novice class includes methods that can...
*      - Retrieve kick damage
*      - Cast spell
*      - Use healing potion
*      - Kill an enemy to get exprience points
*      - Display HP
*      - Display stamina
*      - Display EXP
*
*       Tharathorn Wangthammang
*       6010110458
*       30/01/2019
*
*/

public class Novice {
    private int hp; //current hitpoints
    private int stamina; //current stamina
    private int exp; //current hitpoints
    private int max_hp;
    private int max_stamina;
    private int stamina_rate;
    private int skill_num;
    private int def;
    private boolean blocked = false;
    private boolean dead = false;
    private boolean bluffed = false;
    private boolean reflected = false;
    private double[] defense_probability;
    private String name;
    private Inventory inventory;
    private Skill[] skill_list;

    public Novice(int maxhp, int maxsta , int stam_rate,int skill_no, String Name, int defense, Skill[] skills,double[] def_prob){
        max_hp = maxhp;
        max_stamina = maxsta;
        hp = maxhp;
        defense_probability = def_prob;
        name = Name;
        stamina = maxsta;
        stamina_rate = stam_rate;
        skill_num = skill_no;
        skill_list = skills;
        def = defense;
    }
    public String getName(){
        return name;
    }

    public String[] get_skill_list(){
        String[] list = new String[skill_list.length];
        if(skill_list != null) {
            for (int i = 0 ; i < skill_list.length; i++){
                list[i] = skill_list[i].getName();
            }
        }
        return list;
    }

    public double[] getDefense_probability() {
        return defense_probability;
    }

    public Skill[] getSkills() {
        return skill_list;
    }

    public int get_def(){
        return def;
    }

    public int getStamina_rate(){
        return stamina_rate;
    }

    public void setBlocked(boolean block){
        this.blocked = block;
    }

    public double getbluff_multipiler(){
        double bluff = 1.0;
        if(skill_list != null){
            for(Skill d : skill_list) {
                if (d.getType() != null && d.getType().contains("bluff")) {
                    bluff  = d.getBluff_multipiler();
                }

            }
        }
        return bluff;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void take_damage(int damage){
        hp = hp - damage;
        if(hp <= 0) dead = true;
    }

    public void setStamina(int stam){
        stamina = stam;
    }

    public int stamina_refill(){
        if((max_stamina - stamina) > stamina_rate){
            stamina += stamina_rate;
        }else if((max_stamina - stamina) <= stamina_rate){
            stamina = max_stamina;
        }
        return get_stamina();
    }

    public boolean isDead(){
        if(dead == true){
            return true;
        }else if(hp <= 0){
            return true;
        }else
            return false;
    }

    public boolean isBluffed() {
        return bluffed;
    }

    public void setBluffed(boolean bluffed) {
        this.bluffed = bluffed;
    }

    public boolean isReflected() {
        return reflected;
    }

    public void setReflected(boolean reflected) {
        this.reflected = reflected;
    }

    public int get_hp(){
        return hp;
    }


    public int get_stamina(){
        return stamina;
    }
    public void re_stat(){
        hp = max_hp;
        stamina = max_stamina;
        dead = false;
        bluffed = false;
        blocked = false;
    }





}
