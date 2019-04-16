package game.charactor;


import game.info.Inventory;
import game.info.Item;

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
    private String name;
    private Inventory inventory;
    private String[] skill_list;
    private int[] skill_atk;
    private int[] skill_stamina;

    public Novice(int maxhp, int maxsta,int stam_rate,int skill_no, String Name, int defense ,String[] skillst , int[] atk , int[] stam_cost){
        max_hp = maxhp;
        max_stamina = maxsta;
        hp = maxhp;
        name = Name;
        stamina = maxsta;
        stamina_rate = stam_rate;
        skill_num = skill_no;
        skill_list = skillst;
        skill_atk = atk;
        skill_stamina = stam_cost;
        def = defense;
    }
    public String getName(){
        return name;
    }

    public String[] get_skill_list(Novice player){
        return player.skill_list;
    }

    public int get_def(){
        return def;
    }

    public int getStamina_rate(){
        return stamina_rate;
    }
    public void use_skill_on_monster(Novice player,int skill_num, Monster target){
        if(skill_list != null){

        }
    }

    public void take_damage(int damage){
        hp = hp - damage;
    }

    public void health_potion(){
        hp = hp + 10;
    }

    public int get_hp(){
        return hp;
    }

    public int get_exp(){
        return exp;
    }

    public int get_stamina(){
        return stamina;
    }

    public void cast_spell(){
        stamina = stamina - 20;
    }


    public void store_in_bag(Item newitem){
        inventory.put_item(newitem);
    }

    public void open_inventory(){
        inventory.get_item_list();
    }
}
