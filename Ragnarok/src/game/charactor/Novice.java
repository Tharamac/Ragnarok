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
    private int dollar;
    private Inventory inventory;
    private String[] skill_list;
    private int[] skill_atk;
    private int[] skill_stamina;

    public Novice(int maxhp, int maxsta,int money){
        max_hp = maxhp;
        max_stamina = maxsta;
        hp = maxhp;
        stamina = maxsta;
        dollar = money;
        exp = 0;
        inventory = new Inventory(6);
        skill_list = new String[]{"Normal Hit","Wood Block"};
        skill_atk = new int[]{10,0};
        skill_stamina = new int[]{0,5};
    }
    public void show_skill_list(Novice player){
        for(String i : player.skill_list){
            System.out.println(i);
        }
    }

    public void kick_damage(){
        hp = hp - 10;
    }

    public void health_potion(){
        hp = hp + 10;
    }

    public void enemy_defeated(){
        exp = exp + 10;
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

    public int get_dollar(){
        return dollar;
    }

    public void earn_dollar(int cash){
        dollar = dollar + cash;
    }

    public void lose_dollar(int cash){
        dollar = dollar - cash;
    }

    public void store_in_bag(Item newitem){
        inventory.put_item(newitem);
    }

    public void open_inventory(){
        inventory.get_item_list();
    }
}
