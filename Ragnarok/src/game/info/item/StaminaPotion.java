package game.info.item;

import game.info.Item;

public class StaminaPotion extends Item {
    private int boost;

    public StaminaPotion(String name,int price,int stamina_increase){
        super(name,price);
        boost = stamina_increase;
    }

    public String get_status(){
        return "  +" + boost + " Stamina";
    }
}
