package game.info;
import java.util.ArrayList;
import game.info.Item;

public class Inventory {
    private ArrayList<Item> bag;
    private int maxitem;
    private int item_amount;

    public Inventory(int max_item){
        maxitem = max_item;
        bag = new ArrayList<Item>();

    }

    public void put_item(Item newone){
        if(bag.size() <= maxitem)
            bag.add(newone);
        else{
            System.out.println("Inventory full");
        }
    }

    public void get_item_list(){
            System.out.println("Inventory : contain " + bag.size() + "/" + maxitem + " items");
            System.out.println("--------------------------------------");
            System.out.println("No.  Name                         ");
            System.out.println("--------------------------------------");
        for (int i = 0; i < bag.size() ; i++) {
            System.out.println((i+1) + "    " + bag.get(i).get_name());
        }
            System.out.println("======================================");
    }


}
