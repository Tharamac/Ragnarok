package game.charactor;

public class Skill {
    private String name;
    private String type;
    private int damage_deal;
    private double bluff_multipiler;
    private double block_multipiler;
    private int stamina_cost;

    public Skill(String nme, String tpe,int cost,int dam, double blck, double blff ){
        name = nme;
        type = tpe;
        stamina_cost = cost;
        damage_deal = dam;
        block_multipiler = blck;
        bluff_multipiler = blff;
    }

    public double getBlock_multipiler() {
        return block_multipiler;
    }

    public double getBluff_multipiler() {
        return bluff_multipiler;
    }

    public int getDamage_deal() {
        return damage_deal;
    }

    public int getStamina_cost() {
        return stamina_cost;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
