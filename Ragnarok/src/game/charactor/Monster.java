package game.charactor;

import java.util.Random;

public class Monster {
    private int hp;
    private int atk;
    private int def;
    private String name;
    private boolean dead = false;
    private int[] position;

    public Monster(String nme,int health, int attack_point,int defense_point){
        hp = health;
        name = nme;
        atk = attack_point;
        def = defense_point;
        position = new int[]{(int)(Math.random() * 100 - 100),(int)(Math.random() * 100 - 100)};
    }
    public String getName(){
        return name;
    }
    public int getAtk(){
        return atk;
    }
    public int getDef(){
        return def;
    }
    public String getPosition(){
        return "( " + position[0] + " , " + position[1] + " )";
    }

    public void attack(Novice enemy){
        enemy.take_damage(atk);
    }

    public void take_damage(int atk){
        hp = hp - atk;
        if(hp <= 0){
            dead = true;
        }
    }

    public int getHp(){
        return hp;
    }

    public boolean isDead(){
        if(dead == true){
            return true;
        }else if(hp <= 0){
            return true;
        }else
            return false;
    }


}
