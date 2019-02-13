package game;

import game.charactor.Novice;
import game.info.Inventory;
import game.info.Item;

import java.util.Scanner;
import java.io.*;

public class RouteFight {
    public static void main(String[] args){
        Novice leo = new Novice(100,100,40);
        Scanner key_input = new Scanner(System.in);
        System.out.println("Welcome to Item Shop. What would you like to buy?");
        int choice;
        System.out.println("--------------------------------------");
        System.out.println("Cash : $" + leo.get_dollar());
        System.out.println("--------------------------------------");
        System.out.println("No. Name                         Price");
        System.out.println("--------------------------------------");
        System.out.println(" 1  Health Potion (Small)          $5 ");
        System.out.println("--------------------------------------");
        System.out.println("Buy somethings? (0 for quit) : ");
        choice = key_input.nextInt();
        if(choice == 1){
            if( leo.get_dollar() >= 5){
                Item health_item = new Item("Health Potion (Small)",10,5);
                leo.store_in_bag(health_item);
                leo.lose_dollar(5);
                System.out.println("Cash : $" + leo.get_dollar());
            }else{
                System.out.println("Not enough cash!");
            }
        }
        System.out.println("Thanks! Wanna check your bag? (1-yes , otherwise-no): ");
        int open_bag = key_input.nextInt();
        if(open_bag == 1 )
            leo.open_inventory();
    }
}
