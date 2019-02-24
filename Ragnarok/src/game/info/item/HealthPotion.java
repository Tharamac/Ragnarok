package game.info.item;

import game.info.Item;

public class HealthPotion extends Item {
    private int boost;

    public HealthPotion(String name,int price,int health_increase){
        super(name,price);
        boost = health_increase;
    }

    public String get_status(){
        return "  +" + boost + " Health";
    }
}
