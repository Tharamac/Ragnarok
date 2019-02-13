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

    public Novice(int cur_hp, int cur_stamina , int money){
        max_hp = 100;
        max_stamina = 100;
        hp = cur_hp;
        stamina = cur_stamina;
        dollar = money;
        exp = 0;
        inventory = new Inventory(6);
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
