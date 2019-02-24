package game;

import game.charactor.Novice;
import game.charactor.klass.*;
import game.info.Inventory;
import game.info.Item;
import game.info.item.HealthPotion;
import game.info.item.StaminaPotion;

import java.util.Scanner;
import java.io.*;

public class RouteFight {
    public static void main(String[] args){
        Scanner key_input = new Scanner(System.in);
        Novice thanathorn = new Novice(100,100,100);
        Blade sudarat = new Blade();
        Nexus abhisit = new Nexus();
        sudarat.show_skill_list(sudarat);
        abhisit.show_skill_list(abhisit);
        StaminaPotion senior = new StaminaPotion("Stamina Potion lv.1",10,50);
        HealthPotion junior = new HealthPotion("Health Potion lv.1",10,20);
        senior.get_status();
        senior.get_info(senior.get_status());
        junior.get_status();
        junior.get_info(junior.get_status());

//        System.out.println("Welcome to Item Shop. What would you like to buy?");
//        int choice;
//        System.out.println("--------------------------------------");
//        System.out.println("Cash : $" + leo.get_dollar());
//        System.out.println("--------------------------------------");
//        System.out.println("No. Name                         Price");
//        System.out.println("--------------------------------------");
//        System.out.println(" 1  Health Potion (Small)          $5 ");
//        System.out.println("--------------------------------------");
//        System.out.println("Buy somethings? (0 for quit) : ");
//        choice = key_input.nextInt();
//        if(choice == 1){
//            if( leo.get_dollar() >= 5){
//                Item health_item = new Item("Health Potion (Small)",10,5);
//                leo.store_in_bag(health_item);
//                leo.lose_dollar(5);
//                System.out.println("Cash : $" + leo.get_dollar());
//            }else{
//                System.out.println("Not enough cash!");
//            }
//        }
//        System.out.println("Thanks! Wanna check your bag? (1-yes , otherwise-no): ");
//        int open_bag = key_input.nextInt();
//        if(open_bag == 1 )
//            leo.open_inventory();
    }
}
