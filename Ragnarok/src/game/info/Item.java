package game.info;

public class Item {

    private int cost;
    private String name;

    public Item(String str, int price){
        cost = price;
        name = str;
    }

    public void get_info(String info){
        System.out.println(name);
        System.out.println(info);
        System.out.println("  Cost : $" + cost);
    }

    public String get_name(){
        return name;
    }

//    public void use(){
//
//    }

}
