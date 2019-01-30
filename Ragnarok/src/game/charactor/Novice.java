package game.charactor;

public class Novice {
    private int hp; //current hitpoints
    private int stamina; //current stamina
    private int exp; //current hitpoints
    private int max_hp;
    private int max_stamina;

    public Novice(int cur_hp, int cur_stamina){
        max_hp = 100;
        max_stamina = 100;
        hp = cur_hp;
        stamina = cur_stamina;
        exp = 0;
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

    public static void main(String args[]){
        Novice sexy = new Novice(100,100);
        System.out.println("Current HP: " + sexy.get_hp());
        System.out.println("Current STAMINA: " + sexy.get_stamina());
        System.out.println("Current EXP: " + sexy.get_exp());
        System.out.println("Zombie kicks you! Lose 10 HP");
        sexy.kick_damage();
        System.out.println("Current HP: " + sexy.get_hp());
        System.out.println("You cast spell on a zombie. This lose your stamina by 20 points");
        sexy.cast_spell();
        System.out.println("Current STAMINA: " + sexy.get_stamina());
        System.out.println("Zombie defeated! You got 10 EXP");
        sexy.enemy_defeated();
        System.out.println("Current EXP: " + sexy.get_exp());
        System.out.println("You use 1x Health Potion.");
        sexy.health_potion();
        System.out.println("Current HP: " + sexy.get_hp());

    }
}
