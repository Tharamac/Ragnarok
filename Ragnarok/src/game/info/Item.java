package game.info;

public class Item {

    private int heal;
    private int cost;
    private String name;

    public Item(String str, int heal_pnt, int price){
        heal = heal_pnt;
        cost = price;
        name = str;
    }

    public void get_info(){
        System.out.println("Health Potion");
        System.out.println("  Cost : $" + cost);
        System.out.println("  +"+ heal +" Health");

    }

    public String get_name(){
        return name;
    }

//    public void use(){
//
//    }

}
